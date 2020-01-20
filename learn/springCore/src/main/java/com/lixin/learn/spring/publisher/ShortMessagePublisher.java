package com.lixin.learn.spring.publisher;

import com.lixin.learn.spring.events.ShortMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ShortMessagePublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void sendSms(String receiver, String content) {
        applicationEventPublisher.publishEvent(new ShortMessageEvent(this, receiver, content));
    }

}
