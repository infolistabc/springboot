package com.sun.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.entity.User;
import com.sun.service.IUserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Resource
	private IUserService iUserervice;
	
	@RequestMapping("/add")
	public String addUser() {
		User user = new User();
		user.setName("李四");
		user.setAge(12);
		user.setCreateTime(new Date());
		this.iUserervice.adduser(user);
		return "成功";
	}
	@RequestMapping("/list")
	public PageInfo<User> queryPage() {
		 PageHelper.startPage(1, 2);
		 List<User> list = iUserervice.queryPage();
		 PageInfo<User> page = new PageInfo<User>(list);
		 return page;
	}
}
