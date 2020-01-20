package com.lixin.learn.design.mode.decorator;

import com.lixin.learn.design.mode.enums.EnumMeasureUnit;
import com.lixin.learn.design.mode.enums.EnumSystemUnit;
import com.lixin.learn.design.mode.enums.EnumUnit;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StbUnit extends ConvertUnit {


    public EnumUnit getUnit() {
        return EnumUnit.STB;
    }

    public StbUnit() {
        super.setSystemUnit(EnumSystemUnit.BRITISH);
        super.setMeasureUnit(EnumMeasureUnit.VOLUME);
        //1桶等于0.158987294928立方米
        super.setFactor(BigDecimal.valueOf(0.158987294928));
        super.setCode(3);
    }
}
