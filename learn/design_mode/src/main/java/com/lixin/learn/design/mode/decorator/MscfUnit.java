package com.lixin.learn.design.mode.decorator;

import com.lixin.learn.design.mode.enums.EnumMeasureUnit;
import com.lixin.learn.design.mode.enums.EnumSystemUnit;
import com.lixin.learn.design.mode.enums.EnumUnit;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MscfUnit extends ConvertUnit {

    public EnumUnit getUnit() {
        return EnumUnit.MSCF;
    }

    public MscfUnit() {
        super.setSystemUnit(EnumSystemUnit.BRITISH);
        super.setMeasureUnit(EnumMeasureUnit.VOLUME);
        //1千立方英尺等于28.3168立方米
        super.setFactor(BigDecimal.valueOf(28.3168));
        super.setCode(2);
    }

    public static MscfUnit getInstance() {
        MscfUnit mscf = new MscfUnit();

        return mscf;
    }
}
