package com.lixin.rocketmq.spring.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(String... args) throws Exception {
        rocketMQTemplate.convertAndSend("lixin", "hello,world");
        System.out.println("发送成功");
    }

    public static void main(String[] args){
        SpringApplication.run(ProducerApplication.class, args);
    }
}
