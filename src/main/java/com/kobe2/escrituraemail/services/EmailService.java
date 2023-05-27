package com.kobe2.escrituraemail.services;

import com.kobe2.escrituraemail.config.EmailProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private EmailProps emailProps;
    private void sendSimpleMessage(
            String to,
            String subject,
            String text
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailProps.user);
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
