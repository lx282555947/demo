package com.lixin.learn.spring.service;

import com.lixin.learn.spring.publisher.EmailSender;
import com.lixin.learn.spring.publisher.ShortMessagePublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ListenerTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testListener() {
        EmailSender bean = applicationContext.getBean(EmailSender.class);

        bean.sendEmail("zhangsan", "spring", "收衣服了");
        bean.sendEmail("wangwu", "mybaits", "出太阳了");


        ShortMessagePublisher event = applicationContext.getBean(ShortMessagePublisher.class);
        event.sendSms("zhaoliu", "这是一条短信");
    }
}
