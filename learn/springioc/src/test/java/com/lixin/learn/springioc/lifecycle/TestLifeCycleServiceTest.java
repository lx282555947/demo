package com.lixin.learn.springioc.lifecycle;

import com.lixin.learn.springioc.resource.ResourceBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLifeCycleServiceTest {
    @Autowired
    private TestLifeCycleService lifeCycleService;

    @Autowired
    private ResourceBean resourceBean;

    @Test
    public void test1() {
        lifeCycleService.test();
    }

    @Test
    public void test2() {
        boolean file = resourceBean.getFile();
        System.out.println(file);
    }
}