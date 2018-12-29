package com.lixin.rocketmq.MessageListener;

import com.lixin.rocketmq.bean.RocketMqBean;
import com.lixin.rocketmq.scan.AnotationScan;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyMessageListener implements MessageListenerConcurrently {
    @Autowired
    private AnotationScan anotationScan;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        for (MessageExt messageExt : list) {
            try {
                String topic = messageExt.getTopic();
                RocketMqBean bean = anotationScan.getRocketMqBeanMap().get(topic);
                boolean invoke = bean.invoke(messageExt);
                System.out.println(invoke);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
