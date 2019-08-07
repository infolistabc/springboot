package com.sun.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * rabbitmq直连模式（direct）配置类
 * DirectExchange和Binding可以省略
 * @author wilson
 *
 */
@Configuration
public class DirectConfig {
	//队列的名称
	public final static String DIRECTNAME = "sang-direct";
	/**
	 * 配置Queue实例
	 * @return
	 */
    @Bean
    public Queue queue() {
    	//消息队列名为direct-queue，则routekey即为direct-queue
        return new Queue("direct-queue");
    }
    /**
     * 配置交换器
     * @return
     */
    @Bean
   public DirectExchange directExchange() {
        return new DirectExchange(DIRECTNAME, true, false);
    }
    /**
     * 配置交换器和队列绑定
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(directExchange()).withQueueName();
    }
}
