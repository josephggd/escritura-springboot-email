package com.kobe2.escrituraemail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Email {
    @Autowired
    private EmailProps emailProps;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailProps.host);
        mailSender.setPort(Integer.parseInt(emailProps.port));

        mailSender.setUsername(emailProps.user);
        mailSender.setPassword(emailProps.pw);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", emailProps.protocol);
        props.put("mail.smtp.auth", emailProps.auth);
        props.put("mail.smtp.starttls.enable", emailProps.enable);
        props.put("mail.debug", emailProps.debug);

        return mailSender;
    }

}
