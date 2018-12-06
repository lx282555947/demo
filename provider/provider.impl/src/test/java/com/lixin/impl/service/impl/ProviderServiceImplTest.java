package com.lixin.impl.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lixin.api.service.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderServiceImplTest {

    @Reference()
    private ProviderService providerService;
    @Test
    public void test() {
        String s = providerService.sayHello();
        System.out.println(s);
    }
}