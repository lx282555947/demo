package com.lixin.rocketmq.bean;

import com.lixin.rocketmq.annotation.MQListener;
import com.lixin.rocketmq.annotation.MQService;
import com.lixin.rocketmq.enums.Topic;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
@MQService
public class Test {
    @MQListener(topic = Topic.ZHANGSAN)
    public boolean testMq(MessageExt messageExt) {
        try {
            System.out.println(new String(messageExt.getBody(), "utf-8") + ":" + messageExt.getTopic());
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
