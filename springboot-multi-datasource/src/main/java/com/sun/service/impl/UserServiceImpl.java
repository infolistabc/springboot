package com.sun.service.impl;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sun.dao.master.IMUserDao;
import com.sun.dao.slave.ISUserDao;
import com.sun.entity.User;
import com.sun.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IMUserDao iMUserDao;
	@Resource
	private ISUserDao iSUserDao;
	@Override
	public boolean adduser(User user) {
		return this.iMUserDao.addUser(user)>0;
	}
	@Override
	public List<User> getAllSUser(){
		return this.iSUserDao.findAllUsers();
	}
}
