package com.sun.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.sun.vo.UserInfo;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="名称不能为空")
	private String name;
	@NotBlank(message="用户名不能为空")
	private String username;
	@NotBlank(message="密码不能为空")
	private String password;
	
	private String permission;
	
	public UserInfo builderInfo() {
		UserInfo info = new UserInfo();
		BeanUtils.copyProperties(this, info);
		return info;
	}

	public boolean hasPermission(String method) {
		Boolean result =  false;

		if (StringUtils.equalsIgnoreCase("get", method)) {
			result = StringUtils.contains(permission, "r");
		}else {
			result = StringUtils.contains(permission, "w");
		}
		return result;
	}
}
