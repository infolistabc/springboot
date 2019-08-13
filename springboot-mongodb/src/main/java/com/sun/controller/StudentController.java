package com.sun.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.dao.StudentDao;
import com.sun.vo.Student;

@RestController
public class StudentController {
	@Resource
	private StudentDao studentDao;
	@Resource
	private  MongoTemplate mongoTemplate;
	
	@RequestMapping("/test1")
	public List<Student> test1() {
		List<Student> stus = new ArrayList<>();
		Student stu1 = new Student();
		stu1.setSid(1);
		stu1.setName("小明");
		stu1.setSex("男");
		stus.add(stu1);
        Student stu2 = new Student();
        stu2.setSid(2);
        stu2.setName("小红");
        stu2.setSex("女");
        stus.add(stu2);
        //插入数据
        studentDao.insert(stus);
        //查询数据
        List<Student> stus2 = studentDao.findAll();
        studentDao.deleteAll();
        return stus2;
       // Student book = studentDao.findByNameEquals("朝花夕拾");
        //System.out.println(book);
	}
	@RequestMapping("/test2")
	public List<Student> test2() {
		List<Student> stus = new ArrayList<>();
		Student stu1 = new Student();
		stu1.setSid(1);
		stu1.setName("小明");
		stu1.setSex("男");
		stus.add(stu1);
		
        Student stu2 = new Student();
        stu2.setSid(2);
        stu2.setName("小红");
        stu2.setSex("女");
        stus.add(stu2);
        //插入数据
        this.mongoTemplate.insertAll(stus);
        //查询数据
        List<Student> stus2 = this.mongoTemplate.findAll(Student.class);
        return stus2;
	}	
}
