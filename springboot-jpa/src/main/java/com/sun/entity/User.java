package com.sun.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;
/**
 * @author wilson
 */
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private String phone;
	private Date createTime;
	private Date updateTime;
	private String sex;
}
