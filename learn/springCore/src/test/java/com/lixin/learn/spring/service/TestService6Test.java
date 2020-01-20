package com.lixin.learn.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService6Test {
    @Autowired
    private TestService6 testService6;

    @Test
    public void getServiceSet() {
        testService6.getServiceSet();
    }
}