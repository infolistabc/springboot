package com.sun.mailservice;

import java.io.File;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	@Resource
	JavaMailSender javaMailSender;
	/**
	 * 发送简单邮件
	 * @param from  发送者
	 * @param to    收件人
	 * @param cc    抄送人
	 * @param subject   邮件主题
	 * @param content   邮件内容
	 */
	public void sendSimpleMail(String from,String to,String cc,String subject,String content) {
		SimpleMailMessage simpMsg = new SimpleMailMessage();
		simpMsg.setFrom(from);
		simpMsg.setTo(to);
		simpMsg.setCc(cc);
		simpMsg.setSubject(subject);
		simpMsg.setText(content);
		javaMailSender.send(simpMsg);
		
	}
	/**
	 * 发送带有文件的邮件
	 * @param from 发送人
	 * @param to   收件人
	 * @param cc   抄送人
	 * @param subject   主题
	 * @param content   内容
	 * @param file      文件
	 */
	public void sendFileMail(String from,String to,String cc,String subject,String content,File file) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(content);
			helper.addAttachment(file.getName(), file);
			javaMailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 发送freemarker模板邮件
	 * @param from  发送者
	 * @param to    收件人
	 * @param cc    抄送人
	 * @param subject   邮件主题
	 * @param content   邮件内容
	 */
	public void sendFreemarkerMail(String from,String to,String cc,String subject,String content) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(content,true);
			javaMailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 *发送Thymeleaf模板邮件
	 * @param from  发送者
	 * @param to    收件人
	 * @param cc    抄送人
	 * @param subject   邮件主题
	 * @param content   邮件内容
	 */
	public void sendHtmlMailThymeleaf(String from,String to,String cc,String subject,String content) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(content,true);
			javaMailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
