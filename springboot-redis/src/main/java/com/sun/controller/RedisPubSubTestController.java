package com.sun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sun.vo.Student;

/**
 * @Author: zp
 * @Date: 2019/4/28 13:31
 * @Description:
 */
@RestController
@RequestMapping("/redis")
public class RedisPubSubTestController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 发布者
     * @param message
     */
    //@Scheduled(cron="0/10 * * * * ?")
    public void publish() {
    	String message = "设备推送内容";
        redisTemplate.convertAndSend("devices", message);

    }

    /**
     * 发布者
     * @param message
     */
    //@Scheduled(cron="0/10 * * * * ?")
    public void pubServerlish() {
    	String message = "服务器消息推送";
    	Student student = new Student();
    	student.setName("小明");
    	student.setSid("1");
    	String str = JSON.toJSONString(student);
    	
    	//System.out.println(JSON.toJSONString(student));
    	Object obj =JSON.toJSON(student);
    	System.out.println(obj);
        redisTemplate.convertAndSend("servers", obj);
    }
}

