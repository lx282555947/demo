package com.lixin.learn.spring.service;

import com.lixin.learn.spring.annotation.MovieQualifier;
import com.lixin.learn.spring.enums.MovieFormat;
import org.springframework.stereotype.Component;

@MovieQualifier(value = "fulian4", format = MovieFormat.BULERAY)
@Component
public class TestService7 {
    public void sayHello() {
        System.out.println("复联4蓝光版");
    }
}
