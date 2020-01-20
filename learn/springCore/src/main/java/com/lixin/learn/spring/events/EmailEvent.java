package com.lixin.learn.spring.events;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {
    private String content;
    private String recevier;
    private String subject;


    public EmailEvent(Object source, String receiver, String subject, String content) {
        super(source);
        this.content = content;
        this.recevier = receiver;
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
