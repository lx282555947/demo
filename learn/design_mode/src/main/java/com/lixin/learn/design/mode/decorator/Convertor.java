package com.lixin.learn.design.mode.decorator;

import com.lixin.learn.design.mode.enums.EnumSystemUnit;
import com.lixin.learn.design.mode.enums.EnumUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Convertor {

    @Autowired
    private Map<String, ConvertUnit> convertUnitMap;

    private static Map<Integer, ConvertUnit> codeUnitMap;
    private static Map<EnumUnit, ConvertUnit> enumUnitMap;

    @PostConstruct
    public void init() {
        codeUnitMap = convertUnitMap.entrySet().stream().collect(Collectors.toMap(p -> p.getValue().getCode(), Map.Entry::getValue));
        enumUnitMap = convertUnitMap.entrySet().stream().collect(Collectors.toMap(p -> p.getValue().getUnit(), Map.Entry::getValue));
    }

    public static ConvertUnit getConvertUnit(int code) {
        return codeUnitMap.get(code);
    }

    public static ConvertorContext init(Number number) {
        ConvertorContext convertorContext = new ConvertorContext();
        convertorContext.setNumber(BigDecimal.valueOf(number.doubleValue()));
        return convertorContext;
    }


    static class ConvertorContext {
        private BigDecimal number;
        private ConvertUnit from;
        private ConvertUnit to;

        public ConvertorContext from(EnumUnit from) {
            this.from = enumUnitMap.get(from);
            return this;
        }

        public ConvertorContext to(EnumUnit to) {
            this.to = enumUnitMap.get(to);
            return this;
        }

        public ConvertorContext convert() {
            //判断他们的计量单位是否一致
            if (!from.getMeasureUnit().equals(to.getMeasureUnit())) {
                log.info("单位类型不统一，无法转换");
                throw new RuntimeException("单位类型不统一");
            }
            //根据systemUnit计算转换值
            if (from.getSystemUnit().equals(to.getSystemUnit())) {
                //类型相同，则无需转换
            } else if (from.getSystemUnit().equals(EnumSystemUnit.METRIC)) {
                //由公制转换成英制，则除以目标单位的转换因子
                this.number = this.number.divide(to.getFactor(), 8, BigDecimal.ROUND_HALF_UP);
            } else {
                //由英制转换成公制，则乘以源单位的转换因子
                this.number = this.number.multiply(from.getFactor());
            }
            return this;
        }

        public BigDecimal getValue() {
            return this.number;
        }

        public BigDecimal getKeep2Value() {
            return this.number.setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        public BigDecimal getKeep4Value() {
            return this.number.setScale(4, BigDecimal.ROUND_HALF_UP);
        }

        public BigDecimal getKeep6Value() {
            return this.number.setScale(6, BigDecimal.ROUND_HALF_UP);
        }

        public void setNumber(BigDecimal number) {
            this.number = number;
        }
    }
}
