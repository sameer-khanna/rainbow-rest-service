package com.example.restservice.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.restservice.model.EmailData;

@Component
public class EmailService {
	
	@Autowired
	public JavaMailSender emailSender;

	public void sendHtmlMail(EmailData data) throws MessagingException {

		MimeMessage msg = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(data.getToAddress());

		helper.setSubject(data.getSubject());
		helper.setText(data.getMessage(), true);
		helper.setBcc(data.getBccAdress());
		emailSender.send(msg);

	}

}
