package com.sun.dao.master;

import com.sun.entity.User;

public interface IMUserDao  {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
}
