package com.kobe2.escrituraemail.services;

import com.kobe2.escrituraemail.rmq.Message;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@RabbitListener(queues = "")
public class MqReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MqReceiver.class);
    @Autowired
    private EmailService emailService;
    @RabbitHandler
    public void receive(Message message) {
        logger.info(String.format("received msg %s", message));
        String to = "";
        switch (message.purpose()) {
            case FORGOT ->
                emailService.sendForgotPassEmail(to);
            case CONFIRMATION ->
                emailService.sendConfirmationEmail(to);
        }
    }
}
