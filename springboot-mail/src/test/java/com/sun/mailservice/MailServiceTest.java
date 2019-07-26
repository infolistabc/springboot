package com.sun.mailservice;

import java.io.File;
import java.io.StringWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.sun.MailApplication;
import com.sun.vo.User;
import freemarker.template.Configuration;
import freemarker.template.Template;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
	@Autowired
	private MailService mailService;

	/**
	 * 发送简单邮件
	 */
	@Test
	public void testSendSimpleMail() {
		mailService.sendSimpleMail("2481891283@qq.com", "1092530289@qq.com", "15820106290@163.com", "测试邮件", "测试内容");
	}

	/**
	 * 发送带有附件的邮件
	 */
	@Test
	public void testsendFileMail() {
		mailService.sendFileMail("2481891283@qq.com", "1092530289@qq.com", "15820106290@163.com", "测试邮件", "测试内容",
				new File("/Users/wilson/test.txt"));
	}

	/**
	 * 测试freemarker模板邮件
	 */
	@Test
	public void testsendfreemarkerMail() {
		try {
			// 创建freemarker配置实例
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
			// 获取模板路径
			ClassLoader loader = MailApplication.class.getClassLoader();
			configuration.setClassLoaderForTemplateLoading(loader, "ftl");
			// 加载模板文件
			Template template = configuration.getTemplate("mail.ftl");
			// 创建数据模型
			StringWriter mail = new StringWriter();
			User user = new User();
			user.setGender("男");
			user.setUsername("wilson");
			// 把user转换成mail的输出流,user是数据模型，mail是输出模型
			template.process(user, mail);
			// 邮件发送
			mailService.sendFreemarkerMail("2481891283@qq.com", "1092530289@qq.com", "15820106290@163.com", "测试邮件",
					mail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Autowired
	TemplateEngine templateEngine;

	/**
	 * 测试Thymeleaf模板邮件
	 */
	@Test
	public void testsendHtmlMailThymeleaf() {
		//创建邮件内容对象
		Context ctx = new Context();
		ctx.setVariable("username", "sang");
		ctx.setVariable("gender", "男");
		//把数据写入文件
		String mail = templateEngine.process("mail.html", ctx);
		mailService.sendFreemarkerMail("2481891283@qq.com", "1092530289@qq.com", "15820106290@163.com", "测试邮件", mail);
	}
}
