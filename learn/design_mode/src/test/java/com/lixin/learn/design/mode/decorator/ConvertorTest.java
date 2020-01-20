package com.lixin.learn.design.mode.decorator;

import com.lixin.learn.design.mode.enums.EnumUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConvertorTest {



    @Test
    public void init() {
        BigDecimal number = BigDecimal.ONE;
        BigDecimal convert = Convertor.init(number).from(EnumUnit.CUBIC).to(EnumUnit.MSCF).convert().getKeep6Value();
        System.out.println(convert);
        BigDecimal convert1 = Convertor.init(number).from(EnumUnit.CUBIC).to(EnumUnit.STB).convert().getKeep4Value();
        System.out.println(convert1);
        System.out.println(Convertor.init(1.0));
        System.out.println(Convertor.init(1.0));
        System.out.println(Convertor.init(1.0));
        System.out.println(Convertor.init(1.0));
        System.out.println(Convertor.init(1.0));
    }
}