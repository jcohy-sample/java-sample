package com.jcohy.sample.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:10
 * @since 2022.0.1
 */
public class TemporalAdjuster {

    //4. TemporalAdjuster : 时间校正器
    @Test
    public void test4() {
        LocalDateTime ldt = LocalDateTime.now();
        // result: 2022-07-11T11:04:16.224972600
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        // result: 2022-07-10T11:04:16.224972600
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        // result: 2022-07-17T11:04:16.224972600
        System.out.println(ldt3);

        //自定义: 下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            DayOfWeek dow = ldt4.getDayOfWeek();

            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        // result: 2022-07-12T11:04:16.224972600
        System.out.println(ldt5);
    }
}
