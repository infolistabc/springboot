package com.sun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.sun.dao.IAuditLogDao;
import com.sun.entity.AuditLog;
import com.sun.entity.User;
@Component
public class AuditLogInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private IAuditLogDao iAuditLogDao;
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		AuditLog log =new AuditLog();
		
		log.setMethod(request.getMethod());
		log.setPath(request.getRequestURI());
		
		User user = (User)request.getAttribute("user");
		if(user != null) {
			log.setUsername(user.getName());
		}
		iAuditLogDao.save(log);
		request.setAttribute("logid", log.getId());
		return true;
	}


	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
		Long auditlogid= (Long) request.getAttribute("logid");
		
		AuditLog log= iAuditLogDao.findById(auditlogid).get();
		
		log.setStatus(response.getStatus());
		
		iAuditLogDao.save(log);
		
	}

}
