package com.lixin.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class TestFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static Map<String, Test> taskHandleMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

//    public static Test getInstance(ChannelEnum channelEnum) {
//        taskHandleMap
//    }

    @PostConstruct
    public void init() {
        taskHandleMap = applicationContext.getBeansOfType(Test.class);
    }
}
