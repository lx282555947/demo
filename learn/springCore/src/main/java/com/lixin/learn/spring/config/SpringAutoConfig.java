package com.lixin.learn.spring.config;

import com.lixin.learn.spring.service.TestService3;
import com.lixin.learn.spring.service.TestService5;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class SpringAutoConfig {
    @Bean
    public BeanPostProcessor getBeanPostProcessor(TestService3 testService3) {
        testService3.sayHello();
        return new TestService5();
    }

    @Bean(destroyMethod = "")
    @Description("provide a basic example of a bean")
    public TestService3 getTestService3() {
        return new TestService3();
    }
}
