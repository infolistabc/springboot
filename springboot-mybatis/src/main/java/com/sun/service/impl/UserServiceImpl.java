package com.sun.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sun.dao.IUserDao;
import com.sun.entity.User;
import com.sun.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IUserDao iUserDao;
	@Override
	public boolean adduser(User user) {
		return this.iUserDao.addUser(user)>0;
	}
}
