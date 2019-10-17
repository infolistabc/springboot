package com.sun.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 解决重复添加log的原因
 * @author wilson
 *
 */
@RestControllerAdvice
public class ErrorHandler {
	
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	public Map<String, Object> handle(Exception e){
//		Map<String, Object>  map = new HashMap<>();
//		map.put("message", e.getMessage());
//		map.put("time", new Date().getTime());
//		return map;
//	}
}
