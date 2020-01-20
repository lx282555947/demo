package com.lixin.learn.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

//@Component()
//@Qualifier(value = "haha")
public class TestService3 implements ServiceInterface{
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TestService2 testService2;
    
//    @PostConstruct
    public void init() {
        System.out.println("testService3 init");
    }

    public void close() {
        System.out.println("testService3 close");
    }

//    @PreDestroy
    public void destory() {
        System.out.println("testService3 destory");
    }

    public void sayHello3(String name) {
        System.out.println(name);
    }

    public String sayHello() {
        System.out.println("haha");
        return "wangwu";
    }
}
