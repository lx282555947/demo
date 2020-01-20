package com.lixin.learn.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

//    @Autowired
//    private TestService testService;
    @Autowired
    private TestService2 testService2;
    @Test
    public void sayHello() {
//        String lixin = testService.sayHello("lixin");
//        System.out.println(lixin);
    }

    @Test
    public void sayHello2() {
//        String lixin = testService2.sayHello("lixin");
//        System.out.println(lixin);
    }


}