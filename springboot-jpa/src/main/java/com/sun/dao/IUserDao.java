package com.sun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sun.entity.User;
import org.springframework.data.jpa.repository.Query;

/**
 * @author wilson
 */
public interface IUserDao extends JpaRepository<User, Integer> {
	User findByName(String name);
}
