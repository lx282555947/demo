package com.lixin.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo-consumer.xml")
public class ConsumerImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerImplApplication.class, args);
	}
}
