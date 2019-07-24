package com.sun.dao;

import com.sun.entity.User;
/**
 * 
 * @author wilson
 * @date 2019-0724
 */
public interface IUserDao {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
}
