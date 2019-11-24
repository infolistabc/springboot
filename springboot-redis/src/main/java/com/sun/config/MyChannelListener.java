package com.sun.config;

import java.io.UnsupportedEncodingException;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.alibaba.fastjson.JSONObject;
import com.sun.vo.Student;

public class MyChannelListener implements MessageListener {
	@Override
    public void onMessage(Message message, byte[] pattern) {
//        byte[] channel = message.getChannel();
//        byte[] body = message.getBody();
//        System.out.println("HHH"+message);
//        try {
//            String content = new String(body,"UTF-8");
//            String address = new String(channel,"UTF-8");
//            System.out.println("get " + content + " from " + address);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
		System.out.println("HHH"+message);
//		String str = null;
//		try {
//			str = new String(message.getBody(),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//Student vo = JSONObject.parseObject(message.getBody(), Student.class);
		//Student vo = JSONObject.parseObject(str, Student.class);
		
    }

}
