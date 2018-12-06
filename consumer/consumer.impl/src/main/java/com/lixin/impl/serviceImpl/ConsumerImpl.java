package com.lixin.impl.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lixin.api.service.ConsumerService;
import com.lixin.api.service.ProviderService;
import org.springframework.stereotype.Service;

@Service("consumerService")
public class ConsumerImpl implements ConsumerService {
    @Reference()
    private ProviderService providerService;

    @Override
    public String executeHello() {
        return providerService.sayHello();
    }
}
