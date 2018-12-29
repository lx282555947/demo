package com.lixin.rocketmq.annotation;

import com.lixin.rocketmq.enums.Topic;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MQListener {
    Topic topic();

    String tag() default "*";
}
