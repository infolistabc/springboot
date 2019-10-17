package com.sun.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.sun.dao.IUserDao;
import com.sun.entity.User;
/**
 * 简单的认证过滤器
 * @author wilson
 *
 */
@Component
@Order(1)
public class BasicAuthecationFilter extends OncePerRequestFilter {
	
	@Autowired
	private IUserDao iUserDao;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		//判断请求头是否为空
		if(StringUtils.isNotBlank(authHeader)) {
			
			String token64=StringUtils.substringAfter(authHeader, "Basic "); 
			
			String token =new String  (Base64Utils.decodeFromString(token64));
			
			String [] items=StringUtils.splitByWholeSeparatorPreserveAllTokens(token, ":");
			
			String username =items[0];
			String password =items[1];
			//根据用户明查询数据库
			User user =iUserDao.findByUsername(username);
			
			if(user != null && StringUtils.equals(password,user.getPassword())) {
				request.setAttribute("user", user);
			}

		}
		filterChain.doFilter(request, response);
	}

}
