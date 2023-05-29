package com.kobe2.escrituraemail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
public class EmailConfig {
    @Value("custom.mail.user")
    private String user;
    @Value("custom.mail.pw")
    private String pw;
    @Value("custom.mail.host")
    private String host;
    private final Integer port=587;
    @Value("custom.mail.protocol")
    private String protocol;
    @Value("custom.mail.auth")
    private String auth;
    @Value("custom.mail.enable")
    private String enable;
    @Value("custom.mail.debug")
    private String debug;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.host);
        mailSender.setPort(this.port);

        mailSender.setUsername(this.user);
        mailSender.setPassword(this.pw);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", this.protocol);
        props.put("mail.smtp.auth", this.auth);
        props.put("mail.smtp.starttls.enable", this.enable);
        props.put("mail.debug", this.debug);

        return mailSender;
    }

}
