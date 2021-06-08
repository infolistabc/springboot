package com.sun.service.impl;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.sun.dao.IUserDao;
import com.sun.entity.User;
import com.sun.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private IUserDao iUserDao;

	@Resource
	private RedisTemplate<String,String> redisTemplate;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean adduser(User user) {
		int result = this.iUserDao.addUser(user);
		redisTemplate.opsForValue().set("user","test");
		return result>0;
	}
	@Override
	public List<User> queryPage() {
		List<Integer> ids=Arrays.asList(1,2,3,5);
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(null);
		List<User> list = iUserDao.queryPage(ids);
		//PageHelper.startPage(1,5);
		//List<User> list2 = iUserDao.queryPage();
		//list.addAll(list2);
		return list;
	}
}
