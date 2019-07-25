package com.sun.service;

import java.util.List;

import com.sun.entity.User;



public interface IUserService {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	boolean adduser(User user);
	List<User> getAllSUser();
}
