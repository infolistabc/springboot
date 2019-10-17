package com.sun.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

/**
 * 
 * @author wilson
 *
 */
@Component
public class kaptchaConfig {
	@Bean
	public DefaultKaptcha getDefaultKaptcha() {
		com.google.code.kaptcha.impl.DefaultKaptcha defaultKaptcha = new com.google.code.kaptcha.impl.DefaultKaptcha();
		Properties properties = new Properties();
		//设置图片边框
		properties.setProperty("kaptcha.border", "no");
		//设置图片颜色
		//properties.setProperty("kaptcha.border.color", "105,179,90");
		//设置字体颜色
		properties.setProperty("kaptcha.textproducer.font.color", "blue");
		//设置图片宽度
		properties.setProperty("kaptcha.image.width", "110");
		//设置图片高度
		properties.setProperty("kaptcha.image.height", "40");
		//设置图片字体大小
		properties.setProperty("kaptcha.textproducer.font.size", "30");
		//设置字体
		properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		Config config = new Config(properties);
		defaultKaptcha.setConfig(config);

		return defaultKaptcha;
	}

}
