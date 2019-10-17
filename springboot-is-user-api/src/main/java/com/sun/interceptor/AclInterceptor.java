package com.sun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.sun.dao.IAuditLogDao;
import com.sun.entity.AuditLog;
import com.sun.entity.User;
@Component
public class AclInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private IAuditLogDao iAuditLogDao;
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Boolean result = true;
		
		User  user = (User) request.getAttribute("user");
		 
		if(user == null) {
			response.setContentType("text/plain");
			response.getWriter().write("need authentication");;
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}else {
			String method = request.getMethod();
			
			if(!user.hasPermission(method)) {
				response.setContentType("text/plain");
				response.getWriter().write("fordiddn");
				response.setStatus(HttpStatus.FORBIDDEN.value());
				result = false;
			}
		}
		return true;
	}

}
