package com.lixin.impl;

import com.lixin.impl.serviceImpl.ConsumerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerImplApplicationTests {

	@Autowired
	private ConsumerImpl consumer;
	@Test
	public void contextLoads() {
		String s = consumer.executeHello();
		System.out.println(s);
	}

}
