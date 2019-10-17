 package com.sun.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.google.common.util.concurrent.RateLimiter;
/**
 * 
 * @author wilson
 * 实现服务端请求的简单的限流过滤器，利用google的guava框架
 */
@Component
@Order(1)
public class RateLimitFilter extends OncePerRequestFilter{
	//创建限流器，参数代表每秒生成的令牌数
	private RateLimiter rateLimter = RateLimiter.create(1);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//限制每秒一次的限流请求，如果返回true，则限流没有达到，返回false则直接返回限流过多
		if(rateLimter.tryAcquire()) {
			filterChain.doFilter(request, response);
		}else {
			response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
			response.getWriter().write("too many request!");
			response.getWriter().flush();
			return;
		}
	}

}
