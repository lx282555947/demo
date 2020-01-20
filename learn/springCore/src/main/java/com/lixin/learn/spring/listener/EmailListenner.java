package com.lixin.learn.spring.listener;

import com.lixin.learn.spring.events.EmailEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListenner implements ApplicationListener<EmailEvent> {

    @Override
    public void onApplicationEvent(EmailEvent emailEvent) {
        System.out.println("发送邮件，收件人为：" + emailEvent.getRecevier() + ",主题为：" + emailEvent.getSubject() + ",内容为：" + emailEvent.getContent());
    }
}
