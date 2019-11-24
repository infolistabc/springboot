package com.sun.controller;

import java.math.BigDecimal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.entity.PriceInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jojo
 *
 */
@RestController
@RequestMapping("/prices")
@Slf4j
public class PriceController {
	
	@GetMapping("/{id}")
	public PriceInfo getPrice(@PathVariable Long id,@AuthenticationPrincipal String username) {
		log.info("productId is "+id);
		log.info("username is "+username);
		PriceInfo info = new PriceInfo();
		info.setId(id);
		info.setPrice(new BigDecimal(100));
		return info;
	}

}