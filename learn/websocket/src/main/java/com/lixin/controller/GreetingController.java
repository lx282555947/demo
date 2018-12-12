package com.lixin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private SimpUserRegistry registry;


    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public void greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        simpMessagingTemplate.convertAndSend("/test/getResponse", "Hello, " + message + "!");
    }

    @MessageMapping("/callback")
    public void toOne(String message) {
        JSONObject input = JSON.parseObject(message);
        String msg = input.getString("message");
        String to = input.getString("to");
        SimpUser user = registry.getUser(to);
        System.out.println(user.getName());
        simpMessagingTemplate.convertAndSendToUser(user.getName(), "/queue/getResponse", message);
    }


}
