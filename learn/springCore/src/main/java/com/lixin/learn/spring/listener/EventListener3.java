package com.lixin.learn.spring.listener;

import com.lixin.learn.spring.events.EmailEvent;
import com.lixin.learn.spring.events.ShortMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener3 {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @EventListener
    public ShortMessageEvent switchToSms(EmailEvent emailEvent) {
        ShortMessageEvent smsEvent = new ShortMessageEvent(this, emailEvent.getRecevier(), emailEvent.getContent());
//        applicationEventPublisher.publishEvent(smsEvent);
        return smsEvent;
    }
}
