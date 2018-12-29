package com.lixin.rocketmq.consumer;

import com.lixin.rocketmq.MessageListener.MyMessageListener;
import com.lixin.rocketmq.scan.AnotationScan;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class MyConsumer extends DefaultMQPushConsumer {
    @Autowired
    private AnotationScan anotationScan;
    @Autowired
    private MyMessageListener myMessageListener;

    @PostConstruct
    public void init() {
        try {
            Set<String> topics = anotationScan.getRocketMqBeanMap().keySet();
            for (String topic : topics) {
                try {
                    setConsumerGroup("lixin_group");
                    setNamesrvAddr("localhost:9876");
                    subscribe(topic, "*");
                    registerMessageListener(myMessageListener);
                } catch (MQClientException e) {
                    e.printStackTrace();
                    continue;
                }
            }
            start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
