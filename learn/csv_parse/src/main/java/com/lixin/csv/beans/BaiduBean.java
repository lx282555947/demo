package com.lixin.csv.beans;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaiduBean {
    @CsvBindByPosition(position = 0)
    @CsvDate("yyyyMMdd")
    private Date date;
    @CsvBindByPosition(position = 1)
    private String id;



}
