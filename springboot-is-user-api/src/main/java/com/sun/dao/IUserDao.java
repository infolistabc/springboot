package com.sun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sun.entity.User;

public interface IUserDao extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
}
