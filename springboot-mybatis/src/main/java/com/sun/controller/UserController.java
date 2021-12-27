package com.sun.controller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	private IUserService iUserService;

	@PostMapping("/add")
	public String addUser() {
		User user = new User();
		user.setName("李四");
		user.setAge(12);
		user.setCreateTime(new Date());
		this.iUserService.adduser(user);
		return "成功";
	}
	@GetMapping("/list")
	public PageInfo<User> queryPage() {
		 PageHelper.startPage(1, 2);
		 List<User> list = iUserService.queryPage();
		 PageInfo<User> page = new PageInfo<User>(list);
		 return page;
	}
}
