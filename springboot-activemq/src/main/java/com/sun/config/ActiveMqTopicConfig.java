package com.sun.config;

import com.sun.vo.Message;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;

/**
 * activemq配置类
 * 创建不同的队列进行消息的生产和消费
 * @author wilson
 *
 */
@Component
public class ActiveMqTopicConfig {
	/**
	 * JmsMessagingTemplate 有Spring提供的JMS消息发送模板，用来快速的发送消息
	 */
    @Autowired
    JmsMessagingTemplate messagingTemplate;

    @Resource
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("topic")
    private Topic topic;

    /**
     * 创建一个amq的队列
     * @return
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("topic");
    }

    /**
     * 提供给生产者生产消息到
     * @param msg
     */
    public void sendTopic(Message msg) {
        messagingTemplate.convertAndSend(this.topic, msg);
    }
    /**
     * 消费者订阅主题为amq的消息并消费消息
     * @JmsListener  该注解表示该方法是消息消费者，消息消费者订阅的destination是amq
     * @param msg
     */
    @JmsListener(destination = "topic")
    public void topicConsumer1(Message msg) {
        System.out.println("topicConsumer1:" + msg);
    }

    /**
     * 消费者订阅主题为amq的消息并消费消息
     * @JmsListener  该注解表示该方法是消息消费者，消息消费者订阅的destination是amq
     * @param msg
     */
    @JmsListener(destination = "topic")
    public void topicConsumer2(Message msg) {
        System.out.println("topicConsumer2:" + msg);
    }

}
