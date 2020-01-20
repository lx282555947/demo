package com.lixin.learn.springioc.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Parent {
    private String name;
    private int age;
    private String gender;
    private Child firstChild;
    private Child lastChild;

    public Parent(Child firstChild, Child lastChild) {
        this.firstChild = firstChild;
        this.lastChild = lastChild;
    }
}
