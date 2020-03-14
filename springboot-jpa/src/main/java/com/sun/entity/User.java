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
	@Column(columnDefinition = "int(20) comment '用户编号'")
	private Integer uid;
	private String name;
	private Integer age;
	private Date createTime;
	private Date updateTime;
	private String sex;
}
