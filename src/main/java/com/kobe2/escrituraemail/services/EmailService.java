package com.kobe2.escrituraemail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class EmailService {
    @Value("custom.mail.user")
    private String user;
    @Autowired
    private JavaMailSender emailSender;
    private void sendSimpleMessage(
            String to,
            String subject,
            String text
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.user);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
    public void sendConfirmationEmail(String to) {
        String subj = "";
        String text = "";
        this.sendSimpleMessage(to, subj, text);
    }
    public void sendForgotPassEmail(String to) {
        String subj = "";
        String text = "";
        this.sendSimpleMessage(to, subj, text);
    }
}
