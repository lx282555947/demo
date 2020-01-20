package com.lixin.learn.spring.listener;

import com.alibaba.fastjson.JSON;
import com.lixin.learn.spring.events.EmailEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListenerUseAnnotation {
    @EventListener
    public void ReceiveEmail(EmailEvent emailEvent) {
        System.out.println("接受到邮件3：" + JSON.toJSONString(emailEvent));
    }
}
