package com.lixin.learn.design.mode.decorator;

import com.lixin.learn.design.mode.enums.EnumMeasureUnit;
import com.lixin.learn.design.mode.enums.EnumSystemUnit;
import com.lixin.learn.design.mode.enums.EnumUnit;
import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class ConvertUnit {
    private EnumSystemUnit systemUnit;
    private EnumMeasureUnit measureUnit;
    private BigDecimal factor;
    private int code;

    abstract EnumUnit getUnit();

//    public ConvertUnit(EnumSystemUnit systemUnit, EnumMeasureUnit measureUnit, BigDecimal factor) {
//        this.systemUnit = systemUnit;
//        this.measureUnit = measureUnit;
//        this.factor = factor;
//    }
}
