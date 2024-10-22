package com.sun.config;

import java.time.Duration;

import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.sun.filter.BloomFilterHelper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.ErrorHandler;

/**
 * 
 * @author wilson
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	// 倘若 spring.redis.host 不存在，则会默认为127.0.0.1.
	@Value("${spring.redis.host:#{'127.0.0.1'}}")
	private String hostName;

	@Value("${spring.redis.port:#{6379}}")
	private int port;

	@Value("${spring.redis.password:#{123456}}")
	private String password;

	@Value("${spring.redis.timeout:#{3000}}")
	private int timeout;

	@Value("${spring.redis.lettuce.pool.max-idle:#{16}}")
	private int maxIdle;

	@Value("${spring.redis.lettuce.pool.min-idle:#{1}}")
	private int minIdle;

	@Value("${spring.redis.lettuce.pool.max-wait:#{16}}")
	private long maxWaitMillis;

	@Value("${spring.redis.lettuce.pool.max-active:#{16}}")
	private int maxActive;

	@Value("${spring.redis.database:#{0}}")
	private int databaseId;


	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

		RedisTemplate<String, Object> template = new RedisTemplate<>();

		RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		// 此种序列化方式结果清晰、容易阅读、存储字节少、速度快，所以推荐更换
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		template.setConnectionFactory(redisConnectionFactory);
		// key序列化方式
		template.setKeySerializer(redisSerializer);
		// value序列化
		template.setValueSerializer(jackson2JsonRedisSerializer);
		// value hashmap序列化
		template.setHashValueSerializer(jackson2JsonRedisSerializer);

		return template;
	}

	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory() {

		RedisConfiguration redisConfiguration = new RedisStandaloneConfiguration(
				hostName, port
		);

		// 设置选用的数据库号码
		((RedisStandaloneConfiguration) redisConfiguration).setDatabase(databaseId);

		// 设置 redis 数据库密码
		((RedisStandaloneConfiguration) redisConfiguration).setPassword(password);

		// 连接池配置
		GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxTotal(maxActive);
		poolConfig.setMaxWaitMillis(maxWaitMillis);

		LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder
				= LettucePoolingClientConfiguration.builder()
				.commandTimeout(Duration.ofMillis(timeout));

		LettucePoolingClientConfiguration lettucePoolingClientConfiguration = builder.build();

		builder.poolConfig(poolConfig);

		// 根据配置和客户端配置创建连接
		LettuceConnectionFactory factory = new LettuceConnectionFactory(redisConfiguration, lettucePoolingClientConfiguration);
		return factory;
	}


	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(600)).disableCachingNullValues();
		return cacheConfig;
	}

	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager rcm = RedisCacheManager.builder(lettuceConnectionFactory()).cacheDefaults(cacheConfiguration())
				.transactionAware().build();
		return rcm;
	}

	@Bean
	public MessageListenerAdapter deviceListenerAdapter() {
		return new MessageListenerAdapter(new MyRedisChannelListener());
	}


	@Bean
	public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		// device 频道名称
		container.addMessageListener(deviceListenerAdapter(), new PatternTopic("devices"));
		return container;
	}

	/**
	 * <注册BloomFilterHelper>
	 *
	 * @param
	 * @return com.zy.crawler.config.redis.BloomFilterHelper<java.lang.String>
	 * @author Lifeifei
	 * @date 2019/4/8 13:18
	 */
	@Bean
	public BloomFilterHelper<String> initBloomFilterHelper() {
		return new BloomFilterHelper<>((Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8)
				.putString(from, Charsets.UTF_8), 1000000, 0.01);
	}

}
