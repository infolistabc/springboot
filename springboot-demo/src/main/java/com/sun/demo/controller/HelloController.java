package com.sun.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
	/**
	 * 
	 * @param name 名字
	 * @return
	 */
	@RequestMapping("/hello")
	public String sayHello(String name) {		
		return "Hello"+name+"!";
	}
}
