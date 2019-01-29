package com.lixin.impl;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:dubbo-consumer.xml")
@EnableDubbo
public class ConsumerImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerImplApplication.class, args);
	}
}
