package com.lixin.learn.spring.listener;

import com.alibaba.fastjson.JSON;
import com.lixin.learn.spring.events.EmailEvent;
import com.lixin.learn.spring.events.ShortMessageEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailSmsListener {

    @EventListener({EmailEvent.class, ShortMessageEvent.class})
    public void sendEmailAs(Object object) {
        if (object instanceof EmailEvent) {
            System.out.println("接受到邮件");
        }else {
            System.out.println("接受到短信");
        }
        System.out.println(JSON.toJSONString(object));
    }
}
