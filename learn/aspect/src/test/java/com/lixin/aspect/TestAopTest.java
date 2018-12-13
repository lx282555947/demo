package com.lixin.aspect;

import com.lixin.exception.ParamsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAopTest {

    @Autowired
    private TestAop testAop;

    @Test
    public void sayYes() {

        testAop.sayYes();

    }

    @Test
    public void sayNo() {
    }

    @Test
    public void testReturnString() {
        testAop.returnString("lixin");
    }

    @Test
    public void testReturnInt() {
        testAop.returnInteger(10);
    }

    @Test
    public void testThrowing() {
        try {
            testAop.throwingExample();
        } catch (ParamsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThrowing2() {
        testAop.throwingExample2();
    }

    @Test
    public void testAroundExample() {
        String result = testAop.arountExample();
        System.out.println(result);
    }

    @Test
    public void testAnnotationAround() {
        String username = "13261989780";
        String password = "lx123456";
        testAop.annotation(username, password);
    }
}