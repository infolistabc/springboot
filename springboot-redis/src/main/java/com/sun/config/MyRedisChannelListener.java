package com.sun.config;

import java.io.UnsupportedEncodingException;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * subscribe 订阅者
 */
public class MyRedisChannelListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] channel = message.getChannel();
        byte[] body = message.getBody();

        try {
            String content = new String(body, "UTF-8");
            String address = new String(channel, "UTF-8");
            System.out.println("get " + content + " from " + address);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
