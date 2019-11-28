package com.lixin.learn.springioc.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestLifeCycleService implements InitializingBean, DisposableBean, BeanNameAware {

    @Value("${name}")
    private String name;

    @Override
    public void setBeanName(String name) {
        System.out.println("excute aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("excute destory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("excute initial");
    }
//
//    public void init() {
//        System.out.println("excute init");
//    }

    public void test() {
        System.out.println("test spring bean life cycle");
    }
}
