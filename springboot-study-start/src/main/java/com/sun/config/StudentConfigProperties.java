package com.sun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置项
 * 
 * @Author jiawei huang
 * @Since 2019年8月23日
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "study.config")
public class StudentConfigProperties {
	private int age;

	private String name;

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentConfigProperties [age=" + age + ", name=" + name + "]";
	}
}
