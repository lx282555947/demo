package com.lixin.impl.service.impl;

import com.lixin.api.service.ProviderService;
import org.springframework.stereotype.Service;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String sayHello() {
        return "hello world！";
    }
}
