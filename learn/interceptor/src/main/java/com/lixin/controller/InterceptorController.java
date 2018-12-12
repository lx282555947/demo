package com.lixin.controller;

import com.lixin.annotation.Check;
import com.lixin.annotation.LoginRequired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Check(name = "lixin", value = "haha")
public class InterceptorController {

    @PostMapping(value = "/")
    @LoginRequired
    public String testInterceptor(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password) {
        return "hello, world";
    }
}
