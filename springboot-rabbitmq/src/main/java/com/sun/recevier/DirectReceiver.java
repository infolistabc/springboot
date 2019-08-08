package com.sun.recevier;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
/**
 * direct 只有与生产者routingkey相同的消费者才能进行消息消费
 * @RabbitListener 可以作用在类和方法上，指定消费的队列
 * @author wilson
 *
 */
@Configuration
@RabbitListener(queues = "direct-queue")
public class DirectReceiver {
	/**
	 * @RabbitListener  指定该方法是一个消费方法,queues队列的名称
	 * @param msg  消费信息
	 */
	@RabbitHandler
    public void handler1(String msg) {
        System.out.println("DirectReceiver:" + msg);
    }
}
