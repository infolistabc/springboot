package com.sun.controller;

import com.sun.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.sun.vo.Student;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 测试消息队列
 */
@RestController
@RequestMapping("/redis")
public class TestPubAndSubController {

    @Resource
    RedisUtil redisUtil;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 发布者
     */
    //@Scheduled(cron="0/10 * * * * ?")
    public void publish() {
    	String message = "设备推送内容";
        redisTemplate.convertAndSend("devices", message);
    }

    @PostMapping("/lPush")
    public Long lPush(){
        return redisUtil.lLeftPush("books","java");
    }

    @PostMapping("/lPop")
    public Object lPop(){
        return redisUtil.lLeftPop("books");
    }

    @PostMapping("/LBPop")
    public void LBPop() {
        Object obj = redisUtil.lBLeftPop("books", 10, TimeUnit.SECONDS);
        System.out.println(obj);
    }

}

