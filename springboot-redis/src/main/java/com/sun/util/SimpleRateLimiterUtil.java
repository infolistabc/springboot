package com.sun.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 简单的限流工具类
 */
@Component
@Slf4j
public class SimpleRateLimiterUtil {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 只有在 key 不存在时设置 key 的值
     * @param key
     * @param value
     * @param timeout 设置key的有效期
     * @param unit  时间单位
     * @return
     */
    public boolean setNxRate(String key, int value,long timeout, TimeUnit unit ) {
        if (!redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
            return true;
        }
        return redisTemplate.opsForValue().increment(key,-1L)>=0;
    }

    /**
     * set集合限流的方式
     * @param key
     * @param intervalTime  滑行时间
     * @return
     */
    public boolean setLimitFlow(String key,Long intervalTime){
        Long currentTime = new Date().getTime();
        if(redisTemplate.hasKey("limit")) {
            Integer count = redisTemplate.opsForZSet().rangeByScore(key, currentTime -  intervalTime, currentTime).size();        // intervalTime是限流的时间
            if (count != null && count > 5) {
                return false;
            }
        }
        return redisTemplate.opsForZSet().add(key, UUID.randomUUID().toString(),currentTime);
    }

    /**
     *
     * @param key      接口名称
     * @param capacity 漏斗初始容量
     * @param rate     单位时间内访问频率/秒
     * @param seconds  单位时间(秒)
     * @param tokenNum 每次请求漏斗容量减少的数量
     * @return
     */
    public boolean throttle(String key, int capacity, int rate, int seconds, int tokenNum){
        try {
            DefaultRedisScript script = new DefaultRedisScript();
            script.setResultType(Long.class);
            /*
                cl.throttle命令返回的是一个table，这里只关注第一个元素0表示正常，1表示过载
                KEYS[1]需要设置的key值，结合业务需要可以是接口名称+用户ID+购买的资源包等等等等
                ARGV[1]漏斗初始容量
                ARGV[2]频率次数，结合ARGV[3]一起使用
                ARGV[3]周期（秒），结合ARGV[2]一起使用
                ARGV[4]每次请求漏斗容量减少的数量,默认为1
             */
            script.setScriptText("return redis.call('cl.throttle',KEYS[1], ARGV[1], ARGV[2], ARGV[3], ARGV[4])[1]");
            Long rst = (Long) redisTemplate.execute(script, Arrays.asList(key), capacity, rate, seconds, tokenNum);
            return rst == 0;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }
}
