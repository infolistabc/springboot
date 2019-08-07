package com.sun.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通过实现 ConfirmCallback 接口，消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，也就是只确认是否正确到达
 * Exchange 中
 * 
 * @author wilson
 *
 */
@Component
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostConstruct
	public void init() {
		rabbitTemplate.setConfirmCallback(this); // 指定 ConfirmCallback
		rabbitTemplate.setReturnCallback(this);  // 指定 ReturnCallback
	}
	/**
	 * 消息发送确认
	 * @param	correlationData 消息唯一标识
	 * @param	ack 确认结果
	 * @param	cause 失败原因
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("消息唯一标识：" + correlationData);
		System.out.println("确认结果：" + ack);
		System.out.println("失败原因：" + cause);
	}
	/**
	 * 消息失败返回
	 * @param	message	消息主体
	 * @param	replyCode 失败代码
	 * @param	replyText 失败内容
	 * @param	exchange  失败的交换器
	 * @param	routingKey  路由key
	 */
	@Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息主体 message : "+message);
        System.out.println("消息主体 message : "+replyCode);
        System.out.println("描述："+replyText);
        System.out.println("消息使用的交换器 exchange : "+exchange);
        System.out.println("消息使用的路由键 routing : "+routingKey);
    }
}
