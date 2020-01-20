package com.lixin.learn.design.mode.client;

import com.alibaba.fastjson.JSON;
import com.lixin.learn.design.mode.builderPattern.TestBean;

import java.util.Date;

public class TestBuilder {
    public static void main(String[] args){
        TestBean bean = TestBean.builder().name("lixin").age(11).idcard("42183492084902381980").birthday(new Date()).build();
        System.out.println(JSON.toJSONString(bean));

        TestBean bean2 = TestBean.builder().name("zhangsan").age(8).birthday(new Date()).build();
        System.out.println(JSON.toJSONString(bean2));

    }
}
