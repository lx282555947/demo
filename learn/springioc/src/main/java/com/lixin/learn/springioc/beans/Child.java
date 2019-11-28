package com.lixin.learn.springioc.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Child {
    private String name;
    private int age;
    private String gender;

//    public Child() {
//        this.name = "zhangsan";
//        this.age = 18;
//        this.gender = "girl";
//    }
}
