package com.lixin.learn.spring.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
@Qualifier(value = "haha")
public class TestService4 implements BeanNameAware ,ServiceInterface{

    @Override
    public void setBeanName(String s) {
        System.out.println("bean的名字为:" + s);
    }

    public String sayHello(String name) {
        System.out.println(name);
        return name;
    }

    public String sayHello() {
        System.out.println("zhaoliu");
        return "zhaoliu";
    }
}
