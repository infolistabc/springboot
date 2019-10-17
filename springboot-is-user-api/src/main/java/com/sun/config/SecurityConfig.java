package com.sun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sun.interceptor.AclInterceptor;
import com.sun.interceptor.AuditLogInterceptor;
@Configuration
@EnableJpaAuditing
public class SecurityConfig  implements WebMvcConfigurer{
	
	@Autowired
	private AuditLogInterceptor auditlogInterceptor;
	
	@Autowired
	private AclInterceptor aclInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(auditlogInterceptor);
		registry.addInterceptor(aclInterceptor);
	}

}
