package com.lixin.learn.spring.service;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

public class TestService5 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

//        System.out.println("bean:" + beanName + " created:" + bean.toString());
        System.out.println("该实体类为：" + beanName);
        Arrays.stream(Optional.of(bean).map(p -> p.getClass().getMethods()).get()).filter(p -> null != AnnotationUtils.getAnnotation(p, Component.class)).forEach(p -> System.out.println(p.getName()));
        return bean;
    }
}
