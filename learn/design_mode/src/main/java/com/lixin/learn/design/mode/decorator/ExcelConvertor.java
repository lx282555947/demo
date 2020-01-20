//package com.lixin.learn.design.mode.decorator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//public class ExcelConvertor {
//
//    @Autowired
//    private Map<String, ConvertUnit> convertUnitMap;
//
//    private static Map<Integer, ConvertUnit> codeUnitMap;
//
//    @PostConstruct
//    public void init() {
//        codeUnitMap = convertUnitMap.entrySet().stream().collect(Collectors.toMap(p -> p.getValue().getCode(), Map.Entry::getValue));
//    }
//
//    public ConvertUnit getConvertUnit(int code) {
//        return codeUnitMap.get(code);
//    }
//}
