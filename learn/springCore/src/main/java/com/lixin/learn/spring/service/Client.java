package com.lixin.learn.spring.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestService2.class);
        applicationContext.register(TestService3.class);
        applicationContext.refresh();
        TestService3 bean = applicationContext.getBean(TestService3.class);
        bean.sayHello();
    }
}
