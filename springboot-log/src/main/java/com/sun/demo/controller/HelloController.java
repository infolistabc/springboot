package com.sun.demo.controller;

import com.sun.config.StudentConfigProperties;
import com.sun.other.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin
	@RequestMapping("/hello")
	public String sayHello(String name) {		
		return "Hello"+name+"!";
	}

	@Autowired
	private Student student;

	@Autowired
	private StudentConfigProperties studentConfigProperties;

	@RequestMapping("/getStudent")
	private String getStudent() {
		return "name=[" + student.getName() + "],age=[" + student.getAge() + "],studentConfigProperties=["
				+ studentConfigProperties + "]";
	}
}
