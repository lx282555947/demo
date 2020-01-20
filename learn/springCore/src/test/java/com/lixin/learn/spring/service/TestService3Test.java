package com.lixin.learn.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService3Test {
    @Autowired
    private TestService3 testService3;

    @Test
    public void sayHello3() {
        testService3.sayHello3("zhangsan");
    }
}