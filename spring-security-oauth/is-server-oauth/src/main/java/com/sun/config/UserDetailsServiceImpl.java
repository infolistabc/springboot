package com.sun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
/**
 * 
 * 实现用户详情实现类
 * @author wilson
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 设置网关的用户信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return User.withUsername(username)
					.password(passwordEncoder.encode("123456"))
					//权限，可以理解成角色
					.authorities("ROLE_ADMIN")   
					.build();
	}

}
