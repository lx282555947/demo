package com.lixin.learn.spring.publisher;


import com.lixin.learn.spring.events.EmailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void sendEmail(String receiver, String subject, String conetent) {
        applicationEventPublisher.publishEvent(new EmailEvent(this, receiver, subject, conetent));
    }

}
