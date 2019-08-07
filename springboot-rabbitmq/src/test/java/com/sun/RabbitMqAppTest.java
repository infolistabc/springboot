package com.sun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.config.FanoutConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqAppTest {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Test
	public void testHandler1() {
		this.rabbitTemplate.convertAndSend("direct-queue", "hello direct");
	}
	@Test
	public void testFanout() {
		this.rabbitTemplate.convertAndSend(FanoutConfig.FANOUTNAME,null, "hello fanout");
	}
}
