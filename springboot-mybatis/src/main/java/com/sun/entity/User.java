package com.sun.entity;

import java.util.Date;

import lombok.Data;
@Data
public class User {
	private Integer id;
	private String name;
	private Integer age;
	private Date createTime;
	private Date updateTime;
}
