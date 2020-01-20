package com.lixin.learn.spring.service;

import com.lixin.learn.spring.annotation.MovieQualifier;
import com.lixin.learn.spring.enums.MovieFormat;
import org.springframework.stereotype.Component;

@Component
@MovieQualifier(value = "alita", format = MovieFormat.DVD)
public class TestService8 {
    public void sayHello() {
        System.out.println("阿丽塔DVD版");
    }
}
