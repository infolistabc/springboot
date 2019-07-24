package com.sun.dao;

import com.sun.entity.User;

public interface IUserDao {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
}
