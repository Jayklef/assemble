package com.example.assemble.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    private JavaMailSender mailSender;

    public EmailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String recipient, String msgBody, String subject, String sender) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(sender);
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(msgBody);

        mailSender.send(message);
    }
}
