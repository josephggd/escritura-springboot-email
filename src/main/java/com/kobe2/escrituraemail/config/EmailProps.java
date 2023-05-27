package com.kobe2.escrituraemail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailProps {
    @Value("custom.mq.queue")
    public String queue;
    @Value("custom.mail.user")
    public String user;
    @Value("custom.mail.pw")
    public String pw;
    @Value("custom.mail.host")
    public String host;
    @Value("custom.mail.port")
    public String port;
    @Value("custom.mail.protocol")
    public String protocol;
    @Value("custom.mail.auth")
    public String auth;
    @Value("custom.mail.enable")
    public String enable;
    @Value("custom.mail.debug")
    public String debug;
}
