package com.lixin.learn.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService9Test {
    @Autowired
    private TestService9 testService9;

    @Test
    public void sayHello() {
        testService9.sayHello();
    }
}