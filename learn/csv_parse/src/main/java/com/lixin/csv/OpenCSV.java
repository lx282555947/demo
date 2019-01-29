package com.lixin.csv;

import com.alibaba.fastjson.JSON;
import com.lixin.csv.beans.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class OpenCSV {
    public static void main(String[] args) throws IOException {
        String openPath = "/Users/lixin/Desktop/duizhangwenjian/open.csv";
        String repayPlanPath = "/Users/lixin/Desktop/duizhangwenjian/test.csv";
        String repayItemPath = "/Users/lixin/Desktop/duizhangwenjian/repay_item.csv";
        String repayPath = "/Users/lixin/Desktop/duizhangwenjian/repay.csv";

//        File csv = new File(cvsPath);
//        CSVReader reader = new CSVReader(new FileReader(cvsPath), '|');
//        String [] nextLine;
//        while ((nextLine = reader.readNext()) != null) {
//            // nextLine[] is an array of values from the line
//            System.out.println(nextLine[0] + " " + nextLine[1]);
//        }


//        CsvToBean csvToBean = new CsvToBeanBuilder(new FileReader(openPath)).withSkipLines(2)
//                .withType(Open.class).withSeparator('|').build();
//        System.out.println(JSON.toJSONString(opens));
        Iterator<BaiduBean> iterator = new CsvToBeanBuilder(new FileReader(repayPlanPath))
                .withType(BaiduBean.class).withSeparator('|').withMultilineLimit(2).build().iterator();
        while (iterator.hasNext()) {
            BaiduBean next = iterator.next();
            System.out.println(JSON.toJSONString(next));
        }
//        List<RepayPlan> repayPlans = new CsvToBeanBuilder(new FileReader(repayPlanPath))
//                .withType(RepayPlan.class).withSeparator('|').build().parse();
//        System.out.println(JSON.toJSONString(repayPlans));
//        List<RepayItem> repayItems = new CsvToBeanBuilder(new FileReader(repayItemPath))
//                .withType(RepayItem.class).withSeparator('|').build().parse();
//        System.out.println(JSON.toJSONString(repayItems));
//        List<Repay> repays = new CsvToBeanBuilder(new FileReader(repayPath))
//                .withType(Repay.class).withSeparator('|').build().parse();
//        System.out.println(JSON.toJSONString(repays));
    }
}
