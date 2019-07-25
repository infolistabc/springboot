package com.sun.dao.slave;


import java.util.List;

import com.sun.entity.User;

public interface ISUserDao  {
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	List<User> findAllUsers();
}
