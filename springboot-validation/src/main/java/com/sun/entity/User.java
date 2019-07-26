package com.sun.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * 用户验证实体类
 * 在正式的开发环境中建议把验证的解析配置到valationMessages.properties文件中便于管理
 * @author wilson
 *
 */
@Data
public class User {
	private Integer uid;
	@Size(min=5,max=10,message="{user.name.size}")
	private String name;
	@NotNull(message="{user.address.notnull}")
	private String address;
	@Email(message="{user.email.pattern}")
	@NotNull(message="{user.email.notnull}")
	private String email;
}
