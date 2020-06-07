package com.sun.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 配置全局的CORS配置
 * 如果只是某个方法进行跨域使用@CrossOrigin这个注解，可以作用在类和方法上
 * 例如：@CrossOrigin(origins = "http://domain2.com")
 * @author wilson
 *
 */
public class MyWebMvcConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
        .allowCredentials(true)
        .allowedHeaders("*")
        .maxAge(3600);
	}
	/**
	 * 解决跨域问题的解决方案
	 * @return
	 */
	private CorsConfiguration addCorsConfig() {
	    CorsConfiguration corsConfiguration = new CorsConfiguration();
	    List<String> list = new ArrayList<>();
	    list.add("*");
	    corsConfiguration.setAllowedOrigins(list);
	    // 请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
	    corsConfiguration.addAllowedOrigin("*"); 
	    corsConfiguration.addAllowedHeader("*"); 
	    corsConfiguration.addAllowedMethod("*"); 
	    return corsConfiguration;
	  }
	  @Bean
	  public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", addCorsConfig());
	    return new CorsFilter(source);
	  }
}
