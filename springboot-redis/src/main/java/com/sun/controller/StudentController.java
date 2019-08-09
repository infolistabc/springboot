package com.sun.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.vo.Student;

@RestController
public class StudentController {
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	@RequestMapping("/test")
	public void test() {
		Student stu = new Student();
		stu.setSid("1");
		stu.setName("小明");
		stu.setSex("男");
		this.redisTemplate.opsForValue().set("xiaoming", stu);
	}
}
