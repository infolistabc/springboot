package com.sun.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
/**
 * 
 * @author wilson
 *
 */
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	private String name;
	private Integer age;
	private Date createTime;
	private Date updateTime;
	private String sex;
	private String password;
}
