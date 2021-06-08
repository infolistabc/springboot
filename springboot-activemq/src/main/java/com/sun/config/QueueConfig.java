package com.sun.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.sun.vo.Message;

import javax.jms.Queue;
/**
 * activemq配置类
 * 创建不同的队列进行消息的生产和消费
 * @author wilson
 *
 */
@Component
public class QueueConfig {
	/**
	 * JmsMessagingTemplate 有Spring提供的JMS消息发送模板，用来快速的发送消息
	 */
    @Autowired
    JmsMessagingTemplate messagingTemplate;
    @Autowired
    @Qualifier("queue")
    Queue queue;

    /**
     * 创建一个amq的队列
     * @return
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("amq");
    }

    /**
     * 提供给生产者生产消息到
     * @param msg
     */
    public void send(Message msg) {
        messagingTemplate.convertAndSend(this.queue, msg);
    }
    /**
     * 消费者订阅主题为amq的消息并消费消息
     * @JmsListener  该注解表示该方法是消息消费者，消息消费者订阅的destination是amq
     * @param msg
     */
    @JmsListener(destination = "amq")
    public void receive(Message msg) {
        System.out.println("receive:" + msg);
    }

}
