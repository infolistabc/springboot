package com.sun.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test1Controller {

	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		new Thread(new Test2Controller()).start();
		new Thread(new Test3Controller()).start();
		new Thread(new Test4Controller()).start();
	}

}
