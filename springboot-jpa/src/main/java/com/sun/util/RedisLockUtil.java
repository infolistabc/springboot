package com.sun.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Explain:Redis分布式锁
 */
@Component
public class RedisLockUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private DefaultRedisScript<Long> redisScript;

	private static final Long RELEASE_SUCCESS = 1L;
	/**
	 * 加锁
	 * 
	 * @param key   productId - 商品的唯一标志
	 * @param value 当前时间+超时时间 也就是时间戳
	 * @return
	 */
	public boolean lock(String key, String value) {
		if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {// 对应setnx命令
			// 可以成功设置,也就是key不存在
			return true;
		}
		// 判断锁超时 - 防止原来的操作异常，没有运行解锁操作 防止死锁
		String currentValue = stringRedisTemplate.opsForValue().get(key);
		// 如果锁过期
		if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {// currentValue不为空且小于当前时间
			// 获取上一个锁的时间value
			String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);// 对应getset，如果key存在

			// 假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentValue=A(get取的旧的值肯定是一样的),两个线程的value都是B,key都是K.锁时间已经过期了。
			// 而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的value已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
			if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
				// oldValue不为空且oldValue等于currentValue，也就是校验是不是上个对应的商品时间戳，也是防止并发
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param key  锁key值
	 * @param value 锁对应的value
	 * @param expireTime 锁的有效期，单位秒
	 * @param retryTimes 重试次数。 默认为0，不尝试竞争锁
	 * @param retryInterval 重试间隔，单位毫秒
	 * @return
	 */
	public boolean lock(String key,String value,long expireTime,int retryTimes,long retryInterval) {
		while(true) {
			boolean result = stringRedisTemplate.opsForValue().setIfAbsent(key, value,expireTime,TimeUnit.SECONDS);
			if(result) {
				return true;
			}else if(retryTimes>0) {
				retryTimes--;
				try {
					Thread.sleep(retryInterval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				break;
			}
		}
		return false;
	}

	public boolean unlock(String key, String value) {
		// 使用Lua脚本：先判断是否是自己设置的锁，再执行删除
		Long result = stringRedisTemplate.execute(redisScript, Arrays.asList(key, value));
		// 返回最终结果
		return RELEASE_SUCCESS.equals(result);
	}

	@Bean
	public DefaultRedisScript<Long> defaultRedisScript() {
		DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
		defaultRedisScript.setResultType(Long.class);
		defaultRedisScript.setScriptText(
				"if redis.call('get', KEYS[1]) == KEYS[2] then return redis.call('del', KEYS[1]) else return 0 end");
		return defaultRedisScript;
	}
	/**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String getUniqueKey(){//加一个锁
		SecureRandom secureRandom = new SecureRandom();
        Integer number = secureRandom.nextInt(900000) + 100000;//随机六位数
        return System.currentTimeMillis()+String.valueOf(number);
    }

}
