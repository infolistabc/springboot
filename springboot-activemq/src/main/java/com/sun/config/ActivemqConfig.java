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
public class ActivemqConfig {
    @Autowired
    JmsMessagingTemplate messagingTemplate;
    @Autowired
    @Qualifier("queue")
    Queue queue;
    @Autowired
    @Qualifier("queue2")
    Queue queue2;
    /**
     * 创建一个amq的队列
     * @return
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("amq");
    }
    /**
     * 创建一个amq2的队列
     * @return
     */
    @Bean
    public Queue queue2() {
        return new ActiveMQQueue("amq2");
    }
    /**
     * 提供给生产者生产消息到
     * @param msg
     */
    public void send(Message msg) {
        messagingTemplate.convertAndSend(this.queue, msg);
        messagingTemplate.convertAndSend(this.queue2, msg);
    }
    /**
     * 消费者订阅主题为amq的消息并消费消息
     * @param msg
     */
    @JmsListener(destination = "amq")
    public void receive(Message msg) {
        System.out.println("receive:" + msg);
    }
    /**
     * 消费者订阅主题为amq2的消息并消费消息
     * @param msg
     */
    @JmsListener(destination = "amq2")
    public void receive2(Message msg) {
        System.out.println("receive2:" + msg);
    }
}
