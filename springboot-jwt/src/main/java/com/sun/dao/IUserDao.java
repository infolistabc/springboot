package com.sun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sun.entity.User;
/**
 * 
 * @author wilson
 *
 */
public interface IUserDao extends JpaRepository<User, Integer> {
	/**
	 * 根据名称查询用户信息
	 * @param name
	 * @return
	 */
	User findByName(String name);
}
