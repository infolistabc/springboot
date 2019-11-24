package com.sun.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("admin")
		.password(new BCryptPasswordEncoder().encode("12345"))
		.roles("admin");
	}
	/**
	 * 	配置拦截规则
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//	表示认证授权后才能访问user下的请求
			.antMatchers("/user/*").authenticated()
			//	其他的允许访问
			.anyRequest().permitAll()
			.and()
			//	允许表单登录
			.formLogin()
			//	登录成功后跳转到该页面
			.successForwardUrl("/loginSuccess");
	}

	
	
}
