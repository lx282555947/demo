package com.lixin.dataformat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {
    public static void main(String[] args){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        LocalDate of = LocalDate.of(2018, 10, 1);
        System.out.println(of.getYear());
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("year:" + localDateTime.getYear() + " month:" + localDateTime.getMonthValue() + " day:" + localDateTime.getDayOfMonth() + " hours:" + localDateTime.getHour() + " min:" + localDateTime.getMonthValue() + " seconds:" + localDateTime.getSecond());
        LocalDate newDate = localDateTime.toLocalDate();
        LocalTime newTime = localDateTime.toLocalTime();
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
        System.out.println(localDate.plusYears(1).getYear());
        System.out.println(localDate.getYear());

        LocalDate Date2020 = localDate.withYear(2020);
        System.out.println(Date2020.getYear());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

        String dateStr = localDate.format(formatter);
        System.out.println(dateStr);
    }
}
