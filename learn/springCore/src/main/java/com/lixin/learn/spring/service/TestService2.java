package com.lixin.learn.spring.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
@Qualifier(value = "hehe")
public class TestService2 implements InitializingBean, DisposableBean, ServiceInterface {

    @Override
    public void destroy() throws Exception {
        System.out.println("testService2 destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("testService2 init");
    }

    public String sayHello() {
        System.out.println("zhangsan");
        return "zhangsan";
    }
}
