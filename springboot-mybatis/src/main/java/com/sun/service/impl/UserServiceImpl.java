package com.sun.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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
	@Override
	public List<User> queryPage() {
		// List<Integer> ids=Arrays.asList(1,2,3,5);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(null);
		List<User> list = iUserDao.queryPage(ids);
		//PageHelper.startPage(1,5);
		//List<User> list2 = iUserDao.queryPage();
		//list.addAll(list2);
		return list;
	}
}
