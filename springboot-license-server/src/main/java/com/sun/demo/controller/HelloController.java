package com.sun.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sun.demo.license.Base64Utils;
import com.sun.demo.license.LicenseBo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @author wilson
 * @Date 2019-07-23
 */
@RestController
public class HelloController {
	/**
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/hello")
	public String sayHello(String name) {		
		return "Hello"+name+"!";
	}

	@RequestMapping("/download")
	public void fileDownLoad(HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setHeader("Content-Disposition", "attachment;fileName=a.txt");
		LicenseBo licenseBo = new LicenseBo();
		licenseBo.setSerialNo("1111");
		licenseBo.setCreator("张三");
		licenseBo.setCreateTime("2021");
		licenseBo.setStartTime("2021");
		licenseBo.setDuration(90);
		licenseBo.setCustomer("华云中盛");
		licenseBo.setProject("私有云平台");
		licenseBo.setEncryption("加密数据");
		String json = JSON.toJSONString(licenseBo);
		try {
			OutputStream os  = response.getOutputStream();
			os.write(json.getBytes(StandardCharsets.UTF_8));
			os.flush();
		} catch (IOException e) {
			//log.error("{}",e);
		}
	}
}
