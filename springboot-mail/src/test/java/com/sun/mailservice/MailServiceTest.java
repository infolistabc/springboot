package com.sun.mailservice;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
	@Autowired
	private MailService mailService;

	@Test
	public void testSendSimpleMail() {
		mailService.sendSimpleMail("2481891283@qq.com",
				"1092530289@qq.com", 
				"15820106290@163.com", 
				"测试邮件", "测试内容");
	}
	@Test
	public void testsendFileMail() {
		mailService.sendFileMail("2481891283@qq.com",
				"1092530289@qq.com", 
				"15820106290@163.com", 
				"测试邮件", "测试内容",new File("/Users/wilson/test.txt"));
	}
}
