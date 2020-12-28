package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Bean
	public boolean sendEmail(String subject, String body, String to) {
		boolean isSent = false;
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
			simpleMailMessage.setTo(to);
			javaMailSender.send(simpleMailMessage);
			isSent = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSent;

	}

}
