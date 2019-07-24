package com.sun.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
		user.setSex("男");
		System.out.println("输出结果："+this.iUserervice.addUser(user));
		return "成功";
	}
	@RequestMapping("/update")
	public String updataUser() {
		User user = new User();
		user.setUid(12);
		user.setName("王五");
		user.setAge(33);
		user.setCreateTime(new Date());
		user.setSex("女");
		System.out.println("输出结果："+this.iUserervice.updateAndSaveUser(user));
		return "更新成功";
	}
	@RequestMapping("/delete")
	public String deleteUserByUid() {
		this.iUserervice.deleteById(13);
		return "删除成功";
	}
	@RequestMapping("/listById")
	public User getUserByUid() {
		return this.iUserervice.getUserById(15);
	}
	@RequestMapping("/list")
	public List<User> getAllUsers(){
		return this.iUserervice.getAllUser();
	}
	@RequestMapping("/listByPage")
	public Page<User> getUsersByPage(){
		//分页排序查询
		Sort sort = new Sort(Direction.DESC,"uid");
		PageRequest pageable = PageRequest.of(0, 2,sort);
		return this.iUserervice.getAllByPage(pageable);
	}
	@RequestMapping("/listByName")
	public User getUserByName() {
		return this.iUserervice.getUserByName("张三");
	}
}
