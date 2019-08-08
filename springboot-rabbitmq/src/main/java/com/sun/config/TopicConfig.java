package com.sun.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 1.topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列
 * 2.最终把消息转发到不同的队列中，消费者然后对消息进行消费
 * @author wilson
 *
 */
@Configuration
public class TopicConfig {
	
	public final static String TOPICNAME = "sang-topic";
	/**
	 * 创建交换器bean
	 * @return
	 */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPICNAME, true, false);
    }
    /**
     * 创建三个队列
     * @return
     */
    @Bean
    public Queue xiaomi() {
        return new Queue("xiaomi");
    }
    @Bean
    public Queue huawei() {
        return new Queue("huawei");
    }
    @Bean
    public Queue phone() {
        return new Queue("phone");
    }
    /**
     * 绑定队列
     * .with("xiaomi.#") 表示 xiaomi这个队列只匹配xiaomi.#
     * @return
     */
    @Bean
    public Binding xiaomiBinding() {
        return BindingBuilder.bind(xiaomi()).to(topicExchange())
                .with("xiaomi.#");
    }
    @Bean
    public Binding huaweiBinding() {
        return BindingBuilder.bind(huawei()).to(topicExchange())
                .with("huawei.#");
    }
    @Bean
    public Binding phoneBinding() {
        return BindingBuilder.bind(phone()).to(topicExchange())
                .with("#.phone.#");
    }
}
