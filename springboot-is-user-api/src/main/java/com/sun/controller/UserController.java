package com.sun.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.entity.User;
import com.sun.service.IUserService;
import com.sun.vo.UserInfo;

@RestController
@RequestMapping("/users")
public class UserController {
	@Resource
	private IUserService iUserService;
	
	@RequestMapping("/add")
	public UserInfo create(@RequestBody @Validated UserInfo UserInfo) {
		return iUserService.create(UserInfo);
	}
	
	@PutMapping("/{id}")
	public UserInfo update(@RequestBody UserInfo UserInfo) {
		return iUserService.update(UserInfo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		iUserService.delete(id);
		return;
	}
	
	@GetMapping("/{id}")
	public UserInfo get(@PathVariable Long id,HttpServletRequest request) {
		User user= (User)request.getAttribute("user");
		//用户信息为空或id不相等时判定用户信息认证失败
		if(user == null|| !user.getId().equals(id)) {
			throw new RuntimeException("身份认证信息异常，获取用户信息失败");
		}
		return iUserService.get(id);
	}
	@GetMapping
	public List<UserInfo> query(String name){
		return null;
	}
}
