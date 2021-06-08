package com.sun;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.config.FanoutConfig;
import com.sun.config.TopicConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqAppTest {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Test
	public void testDirect() {
		//发送消息到交换器即可，它会负责转发到指定的队列
		while (true){
			try {
				List list = new ArrayList<>();
				list.add("uid");
				list.add("pid");
				this.rabbitTemplate.convertAndSend("direct-queue", list);
				Thread.sleep(1000L);
			}catch (Exception e){
				e.printStackTrace();
			}

		}

	}
	@Test
	public void testFanout() {
		//发送消息到交换器即可，它会负责转发到指定的队列
		this.rabbitTemplate.convertAndSend(FanoutConfig.FANOUTNAME,null, "hello fanout");
	}
	@Test
	public void testTopic() {
		//发送消息到交换器即可，它会负责转发到指定的队列
		this.rabbitTemplate.convertAndSend(TopicConfig.TOPICNAME,"xiaomi.news", "小米新闻");
		this.rabbitTemplate.convertAndSend(TopicConfig.TOPICNAME,"huawei.news", "华为新闻");
		this.rabbitTemplate.convertAndSend(TopicConfig.TOPICNAME,"xiaomi.phone", "小米新闻");
		this.rabbitTemplate.convertAndSend(TopicConfig.TOPICNAME,"huawei.phone", "华为新闻");
		this.rabbitTemplate.convertAndSend(TopicConfig.TOPICNAME,"phone.news", "手机新闻");
	}
}
