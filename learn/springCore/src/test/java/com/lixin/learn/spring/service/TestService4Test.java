package com.lixin.learn.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService4Test {
    @Autowired
    private TestService4 testService4;

    @Test
    public void sayHello() {
        testService4.sayHello("wangwu");

    }
}