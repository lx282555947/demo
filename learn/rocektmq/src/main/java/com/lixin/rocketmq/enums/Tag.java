package com.lixin.rocketmq.enums;

public enum Tag {
    Tag1("tag1"),
    Tag2("tag2"),
    Tag3("tag3");

    private String name;

    Tag(String name) {
        this.name = name;
    }
}
