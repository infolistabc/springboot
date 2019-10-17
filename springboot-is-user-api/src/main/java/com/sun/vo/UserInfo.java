package com.sun.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserInfo {
	
	private Long id;
	@NotBlank(message="名称不能为空")
	private String name;
	@NotBlank(message="用户名不能为空")
	private String username;
	@NotBlank(message="密码不能为空")
	private String password;
}
