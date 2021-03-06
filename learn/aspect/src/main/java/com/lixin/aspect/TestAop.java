package com.lixin.aspect;

import com.alibaba.fastjson.JSONObject;
import com.lixin.annotation.MyMethodAnnotation;
import com.lixin.annotation.MyTypeAnnotation;
import com.lixin.bean.User;
import com.lixin.exception.ParamsException;
import org.springframework.stereotype.Component;

@Component
@MyTypeAnnotation(value="lixin")
public class TestAop {

    public void sayYes() {
        System.out.println("say yes!");
    }

    public void sayNo() {
        System.out.println("say no!");
    }

    public String returnString(String name) {
        return name;
    }

    public int returnInteger(int a) {
        return a;
    }

    public int throwingExample() throws ParamsException {
        throw new ParamsException("参数异常");
    }

    public int throwingExample2() {
        int number = 1 / 0;
        return number;
    }

    public String arountExample() {
        System.out.println("around");
        return "haha";
    }

    public void argsExample(String username) {
        System.out.println("username");
    }

    @MyMethodAnnotation(value = "hello,lixin")
    public JSONObject annotation(User user) {
        JSONObject result = new JSONObject();
        System.out.println("method annotatian");
        result.put("id", "123243");
        return result;
    }
}
