package com.sun.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanout(广播模式)多个队列共享同样的信息
 * 这种路由的策略routingkey将不会起到任何上网作用
 * @author wilson
 *
 */
@Configuration
public class FanoutConfig {
	
	public final static String FANOUTNAME = "sang-fanout";

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(FANOUTNAME, true, false);
	}
	
	@Bean
	public Queue queueOne() {
		return new Queue("queue-one");
	}

	@Bean
	public Queue queueTwo() {
		return new Queue("queue-two");
	}
	 /**
     * 交换器绑定第一个队列
     * @return
     */
	@Bean
	public Binding bindingOne() {
		return BindingBuilder.bind(queueOne()).to(fanoutExchange());
	}
	 /**
     * 交换器绑定第二个队列
     * @return
     */
	@Bean
	public Binding bindingTwo() {
		return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
	}

}
