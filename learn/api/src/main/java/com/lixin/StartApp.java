package com.lixin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.lixin.config.ApplicationEnvironmentPreparedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lixin")
@EnableApolloConfig
public class StartApp {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(StartApp.class);
        app.addListeners(new ApplicationEnvironmentPreparedEventListener());
        app.run();
    }
}
