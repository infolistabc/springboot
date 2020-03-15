package com.sun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.service.RedisPushAndPop;

@RestController
public class TestPushAndPop {
	@Resource
	private RedisPushAndPop redisPushAndPop;
	
	@Autowired
    private RedisTemplate<String,Object> redisTemplate;
	@RequestMapping("push")
	public void lpush(){
		String key="test";
		String id = "1";
		Object obj  =redisPushAndPop.lpush(key,id);
		
		System.out.println("push"+obj.toString());
	}
	
}
