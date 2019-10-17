package com.sun.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.sun.dao.IUserDao;
import com.sun.entity.User;
import com.sun.service.IUserService;
import com.sun.vo.UserInfo;
@Service
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao iUserDao;

	@Override
	public UserInfo create(UserInfo userInfo) {
		User user = new User();
		BeanUtils.copyProperties(userInfo, user);
		user.setUsername(null);
		iUserDao.save(user);
		userInfo.setId(user.getId());
		return userInfo;
	}

	@Override
	public UserInfo update(UserInfo userInfo) {
		User user = new User();
		BeanUtils.copyProperties(userInfo, user);
		return iUserDao.saveAndFlush(user).builderInfo();
	}

	@Override
	public void delete(Long id) {
		iUserDao.deleteById(id);
	}

	@Override
	public UserInfo get(Long id) {
		return iUserDao.findById(id).get().builderInfo();
	}

	@Override
	public List<UserInfo> query(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
