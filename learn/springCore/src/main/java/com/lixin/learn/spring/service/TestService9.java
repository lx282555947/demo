package com.lixin.learn.spring.service;

import com.lixin.learn.spring.annotation.MovieQualifier;
import com.lixin.learn.spring.enums.MovieFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService9 {

    @Autowired
    @MovieQualifier(value = "alita", format = MovieFormat.DVD)
    private TestService8 testService8;

    public void sayHello() {
        testService8.sayHello();
    }
}
