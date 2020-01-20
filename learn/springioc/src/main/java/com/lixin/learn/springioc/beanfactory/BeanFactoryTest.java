package com.lixin.learn.springioc.beanfactory;

import com.lixin.learn.springioc.beans.Child;
import com.lixin.learn.springioc.beans.Parent;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanFactoryTest {
    public static void main(String[] args) {
        //defaultListenableBeanFactory 因为实现了BeanFactory和beanRegistory  因此该类既是一个bean工厂，又是一个bean注册中心
        DefaultListableBeanFactory factoryAndRegister = new DefaultListableBeanFactory();
        bingViaCode(factoryAndRegister);
        Parent bean = factoryAndRegister.getBean(Parent.class);
        System.out.println(bean.getFirstChild());
        System.out.println(bean.getLastChild());
        System.out.println(bean.getFirstChild() == bean.getLastChild());
    }

    public static void bingViaCode(BeanDefinitionRegistry registry) {
        //生成实体类对应的类定义（包含类的基本信息，类类型、类属性以及类方法）
        RootBeanDefinition parentDefinition = new RootBeanDefinition(Parent.class);
        RootBeanDefinition childDefinition = new RootBeanDefinition(Child.class);
        //想实体类注册中心注册
        registry.registerBeanDefinition("parent", parentDefinition);
        registry.registerBeanDefinition("child", childDefinition);
        //指定依赖关系
        //1、通过构造方法的方式
//        ConstructorArgumentValues argsValue = new ConstructorArgumentValues();
//        argsValue.addIndexedArgumentValue(0, childDefinition);
//        argsValue.addIndexedArgumentValue(1, childDefinition);
//        parentDefinition.setConstructorArgumentValues(argsValue);
        //2、通过setter
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("firstChild", childDefinition));
        propertyValues.addPropertyValue(new PropertyValue("lastChild", childDefinition));
        parentDefinition.setPropertyValues(propertyValues);
    }
}


