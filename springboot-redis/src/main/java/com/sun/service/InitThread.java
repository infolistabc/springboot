package com.sun.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class InitThread {
	@Resource
	private RedisPushAndPop redisPushAndPop;
	
	@PostConstruct
    public void init() {
		//System.out.println("-------------启动线程----------------");
		//redisPushAndPop.asyncTask1();;
    }

}
