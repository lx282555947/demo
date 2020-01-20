package com.lixin.learn.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TestService6 {
    @Qualifier("hehe")
    @Autowired
    private Set<ServiceInterface> serviceInterfaceSet;

    public void getServiceSet() {
        serviceInterfaceSet.stream().forEach(ServiceInterface::sayHello);
    }
}
