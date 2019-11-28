package com.lixin.learn.springioc.processor;

import com.lixin.learn.springioc.lifecycle.TestLifeCycleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TestLifeCycleService) {
            System.out.println("excute postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TestLifeCycleService) {
            System.out.println("excute postProcessAfterInitialization");
        }
        return bean;
    }
}
