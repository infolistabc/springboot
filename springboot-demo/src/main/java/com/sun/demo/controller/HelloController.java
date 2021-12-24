package com.sun.demo.controller;

import com.sun.config.StudentConfigProperties;
import com.sun.demo.config.IgnoreUrlsConfig;
import com.sun.other.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

//	@Autowired
//	private Student student;

	@Autowired
	private StudentConfigProperties studentConfigProperties;

	@Autowired
	private IgnoreUrlsConfig ignoreUrlsConfig;

	@RequestMapping("/getStudent")
	public String getStudent() {
//		return "name=[" + student.getName() + "],age=[" + student.getAge() + "],studentConfigProperties=["
//				+ studentConfigProperties + "]";
		return "studentConfigProperties"+studentConfigProperties;
	}

	@RequestMapping("/setStudent")
	public void setStudent(){
		studentConfigProperties.setAge(12);
		studentConfigProperties.setName("张三");
	}

	@RequestMapping("/getUrl")
	public List getIgnoreUrl(){
		return ignoreUrlsConfig.getUrls();
	}

	@RequestMapping("/setUrl")
	private void setUrl(){
		List<String> urls = ignoreUrlsConfig.getUrls();
		urls.addAll(urls);
	}
}
