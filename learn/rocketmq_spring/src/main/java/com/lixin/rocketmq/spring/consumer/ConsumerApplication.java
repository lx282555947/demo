package com.lixin.rocketmq.spring.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class ConsumerApplication{

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Service
    @RocketMQMessageListener(topic = "lixin", consumerGroup = "my-consumer_test-topic-1")
    public class MyConsumer1 implements RocketMQListener<String> {
        public void onMessage(String message) {
            System.out.println("接受到的message为:" + message);
        }
    }

//    @Slf4j
//    @Service
//    @RocketMQMessageListener(topic = "test-topic-2", consumerGroup = "my-consumer_test-topic-2")
//    public class MyConsumer2 implements RocketMQListener<OrderPaidEvent>{
//        public void onMessage(OrderPaidEvent orderPaidEvent) {
//            log.info("received orderPaidEvent: {}", orderPaidEvent);
//        }
//    }
}
