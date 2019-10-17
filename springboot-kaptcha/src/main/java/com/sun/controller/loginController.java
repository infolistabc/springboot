package com.sun.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;

@Api("登录接口")
@RestController
public class loginController {
	
	@Autowired
	private Producer producer;
	
	/**
	 * 客户端传递一个uuid，服务端根据uuid作为key把code存储在redis或其他缓存中，用于登录接口的做验证吗的验证操作
	 * @param response
	 * @throws IOException
	 */
	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response) throws IOException {
		//设置返回类型
		response.setContentType("image/jepg");
		//设置缓存类型
		response.setHeader("Cache-Control", "no-store,no-cache");
		//生成code
		String code = producer.createText();
		//根据code获取图片
		BufferedImage image = producer.createImage(code);
		//创建输出流
		ServletOutputStream out = response.getOutputStream();
		//输出图片
		ImageIO.write(image, "jpg", out);
		//关闭输出流
		IOUtils.closeQuietly(out);
	}
}
