package com.sun.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 简单的限流工具类
 */
@Component
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
}
