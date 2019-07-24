package com.sun.service;

import com.sun.entity.User;

public interface IUserService {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	boolean adduser(User user);
}
