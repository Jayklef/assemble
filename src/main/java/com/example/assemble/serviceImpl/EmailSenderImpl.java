package com.example.assemble.serviceImpl;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.MessagingException;

public class EmailSenderImpl {

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    EmailSender emailSender = new EmailSender(mailSender);

    String sender = "";
    String recipient = "jerry@woodcoreapp.com";
    String subject = "Hello from assemble in springboot";
    String msgBody = "<p> Hello, </p> <p>This is a test email from assemble project</p>";


}
