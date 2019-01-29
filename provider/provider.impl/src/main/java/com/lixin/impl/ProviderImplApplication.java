package com.lixin.impl;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:dubbo-provider.xml")
@EnableDubbo
public class ProviderImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderImplApplication.class, args);
	}
}
