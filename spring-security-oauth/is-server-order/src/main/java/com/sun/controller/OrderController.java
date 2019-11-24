package com.sun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.entity.OrderInfo;
import com.sun.entity.PriceInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jojo
 *
 */
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {
	
	@Autowired
	private OAuth2RestTemplate restTemplate;
	//@AuthenticationPrincipal String username
	
	@PostMapping
	public OrderInfo create(@RequestBody OrderInfo info,@AuthenticationPrincipal String username) {
		log.info("userId is "+username);
		PriceInfo price = restTemplate.getForObject("http://localhost:9070/prices/"+info.getProductId(), PriceInfo.class);
		log.info("price is "+price.getPrice());
		return info;
	}
	@GetMapping("/low")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "low permission";
    }
}