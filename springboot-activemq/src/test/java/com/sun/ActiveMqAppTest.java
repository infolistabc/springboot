package com.sun;

import java.util.Date;

import com.sun.config.ActiveMqTopicConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.config.QueueConfig;
import com.sun.vo.Message;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqAppTest {
	@Autowired
    QueueConfig queueConfig;

    @Autowired
    ActiveMqTopicConfig topicConfig;

    @Test
    public void testQueue() {
        int i=10;
        while (i<=10){
            Message msg = new Message();
            msg.setContent("hello jms!");
            msg.setDate(new Date());
            queueConfig.send(msg);
           // i--;
        }
    }

    @Test
    public void testTopic() {
        try {
            while (true){
                System.out.println("send topic!");
                Message msg = new Message();
                msg.setContent("hello topic!");
                msg.setDate(new Date());
                topicConfig.sendTopic(msg);
                Thread.sleep(1000L);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
