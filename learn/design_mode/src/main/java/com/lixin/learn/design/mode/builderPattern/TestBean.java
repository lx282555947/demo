package com.lixin.learn.design.mode.builderPattern;

import java.util.Date;

public class TestBean {

    private String name;
    private int age;
    private String idcard;
    private Date birthday;

    public TestBean(BeanBuilder beanBuilder) {
        this.name = beanBuilder.builderName;
        this.age = beanBuilder.builderAge;
        this.idcard = beanBuilder.builderIdcard;
        this.birthday = beanBuilder.builderBirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public static BeanBuilder builder() {
        return new BeanBuilder();
    }

    public static class BeanBuilder {
        private String builderName;
        private int builderAge;
        private String builderIdcard;
        private Date builderBirthday;

        public BeanBuilder name(String name) {
            this.builderName = name;
            return this;
        }

        public BeanBuilder age(int age) {
            this.builderAge = age;
            return this;
        }

        public BeanBuilder idcard(String idcard) {
            this.builderIdcard = idcard;
            return this;
        }

        public BeanBuilder birthday(Date birthday) {
            this.builderBirthday = birthday;
            return this;
        }

        public TestBean build(BeanBuilder beanBuilder) {
            return new TestBean(beanBuilder);
        }

        public TestBean build() {
            return new TestBean(this);
        }


    }
}
