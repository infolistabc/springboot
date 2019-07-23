package com.sun.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author wilson
 * @Date 2019-07-23
 */
@RestController
public class HelloController {
	/**
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/hello")
	public String sayHello(String name) {		
		return "Hello"+name+"!";
	}
}
