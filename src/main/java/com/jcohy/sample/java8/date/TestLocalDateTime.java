package com.jcohy.sample.java8.date;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:06
 * @since 2022.0.1
 */
public class TestLocalDateTime {

    //1. LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        // result: 2022-07-11T11:05:11.209797400
        System.out.println(ldt);

        LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
        // result: 2016-11-21T10:10:10
        System.out.println(ld2);

        LocalDateTime ldt3 = ld2.plusYears(20);
        // result: 2036-11-21T10:10:10
        System.out.println(ldt3);

        LocalDateTime ldt4 = ld2.minusMonths(2);
        // result: 2016-09-21T10:10:10
        System.out.println(ldt4);

        // result: 2022
        System.out.println(ldt.getYear());
        // result: 7
        System.out.println(ldt.getMonthValue());
        // result: 11
        System.out.println(ldt.getDayOfMonth());
        // result: 11
        System.out.println(ldt.getHour());
        // result: 5
        System.out.println(ldt.getMinute());
        // result: 11
        System.out.println(ldt.getSecond());
    }
}