package com.sun.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags="用户数据接口")
@RestController
public class UserController {
	@ApiOperation("新增用户")
	@PostMapping("add")
	public List<String> addUser(@Validated User user,BindingResult result){
		List<String> errors = new ArrayList<>();
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error : allErrors) {
				errors.add(error.getDefaultMessage());
			}
		}
		return errors;
	}
}
