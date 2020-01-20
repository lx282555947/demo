package com.lixin.learn.spring.listener;

import com.lixin.learn.spring.events.EmailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener2 implements ApplicationListener<EmailEvent> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onApplicationEvent(EmailEvent emailEvent) {
//        applicationEventPublisher.publishEvent(new EmailEvent(this, "wangwu", "spring2", "下雨收衣服了2"));
//        while (true) {
//
//        }
//        System.out.println("接受邮件2，接受人为：" + emailEvent.getRecevier() + "，主题为：" + emailEvent.getSubject() + "，内容为：" + emailEvent.getContent());
    }

}
