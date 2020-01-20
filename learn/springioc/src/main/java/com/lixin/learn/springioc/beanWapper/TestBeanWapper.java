package com.lixin.learn.springioc.beanWapper;

import com.alibaba.fastjson.JSON;
import com.lixin.learn.springioc.beans.Child;
import com.lixin.learn.springioc.beans.Parent;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class TestBeanWapper {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child firstChild = new Child();
        firstChild.setName("zhangsan");
        Child lastChild = new Child();
        lastChild.setName("lisi");
        BeanWrapper beanWapper = new BeanWrapperImpl(parent);
        beanWapper.setPropertyValue("firstChild", firstChild);
        beanWapper.setPropertyValue("lastChild", lastChild);
        Object object = beanWapper.getWrappedInstance();
        System.out.println(JSON.toJSONString(object));
    }
}
