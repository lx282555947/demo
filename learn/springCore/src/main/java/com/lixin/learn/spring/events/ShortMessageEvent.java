package com.lixin.learn.spring.events;

import org.springframework.context.ApplicationEvent;

public class ShortMessageEvent extends ApplicationEvent {
    private String receiver;
    private String content;

    public ShortMessageEvent(Object source) {
        super(source);
    }

    public ShortMessageEvent(Object source, String receiver, String content) {
        super(source);
        this.receiver = receiver;
        this.content = content;
    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
