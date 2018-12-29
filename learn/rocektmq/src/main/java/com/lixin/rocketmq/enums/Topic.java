package com.lixin.rocketmq.enums;

public enum Topic {
    ZHANGSAN("zhangsan"),
    WANGWU("wangwu"),
    LISI("lisi");

    private String name;

    Topic(String name) {
        this.name = name;
    }
}
