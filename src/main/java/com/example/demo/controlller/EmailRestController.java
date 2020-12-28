package com.example.demo.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmailService;

@RestController
public class EmailRestController {
	@Autowired
	private EmailService emailservice;

	@GetMapping("/send")
	public String sendEmail() {
		String subject = "dont ignore this mail";
		String body = "please prepare well and get good job";
		String to = "vinodh.sun6@gmail.com";
		boolean isSent = emailservice.sendEmail(subject, body, to);
		if (isSent) {
			return "yes i sended email successfully";
		}
		return "yes i sended email failed";

	}
}
