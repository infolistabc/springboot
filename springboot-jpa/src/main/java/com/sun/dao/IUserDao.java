package com.sun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sun.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wilson
 */
public interface IUserDao extends JpaRepository<User, Integer> {
	User findByName(String name);

	List<User> findByPhone(String phone);
}
