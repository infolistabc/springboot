package com.sun.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sun.dao.IUserDao;
import com.sun.entity.User;
import com.sun.service.IUserService;
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IUserDao iUserDao;
	@Override
	public boolean addUser(User user) {
		return this.iUserDao.save(user)!=null;
	}
	
	@Override
	public boolean updateAndSaveUser(User user) {
		return this.iUserDao.saveAndFlush(user)!=null;
	}
	@Override
	public void deleteById(Integer uid) {
		this.iUserDao.deleteById(uid);
		return;
	}
	@Override
	public User getUserById(Integer uid) {
		Optional<User> optional = this.iUserDao.findById(uid);
		return optional.get();
	}
	@Override
	public List<User> getAllUser() {
		return this.iUserDao.findAll();
	}

	@Override
	public Page<User> getAllByPage(Pageable pageable) {
		return this.iUserDao.findAll(pageable);
	}

	@Override
	public User getUserByName(String name) {
		return this.iUserDao.findByName(name);
	}

	
	
	
}
