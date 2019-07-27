package com.sun;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.config.ActivemqConfig;
import com.sun.vo.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqAppTest {
	@Autowired
    ActivemqConfig jmsComponent;
    @Test
    public void contextLoads() {
        Message msg = new Message();
        msg.setContent("hello jms!");
        msg.setDate(new Date());
        jmsComponent.send(msg);
    }
}
