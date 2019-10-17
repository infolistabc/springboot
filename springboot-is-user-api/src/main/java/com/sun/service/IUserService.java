package com.sun.service;

import java.util.List;


import com.sun.vo.UserInfo;

public interface IUserService {
	 /**
	  * 新增用户
	  * @param UserInfo 
	  * @return
	  */
	 UserInfo create(UserInfo UserInfo);
	 /**
	  * 修改用户
	  * @param UserInfo
	  * @return
	  */
	 UserInfo update( UserInfo UserInfo);
	 /**
	  * 根据ID删除用户
	  * @param id
	  */
	 void delete(Long id);
	 /**
	  * 根据ID查询用户
	  * @param id
	  * @return
	  */
	 UserInfo get(Long id);
	 /**
	  * 根据name查询用户信息
	  * @param name
	  * @return
	  */
	 List<UserInfo> query(String name);
}
