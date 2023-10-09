package com.jcohy.sample.java8.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static java.time.ZoneId.*;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:11
 * @since 2022.0.1
 */
public class FormatDateTest {

    //6.ZonedDate、ZonedTime、ZonedDateTime :  带时区的时间或日期
    @Test
    public void test7() {
        LocalDateTime ldt = LocalDateTime.now(of("Asia/Shanghai"));
        // result: 2022-07-11T11:01:58.521871100
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(of("US/Pacific"));
        // result: 2022-07-10T20:01:58.523869200-07:00[US/Pacific]
        System.out.println(zdt);
    }

    @Test
    public void test6() {
        Set<String> set = getAvailableZoneIds();
        set.forEach(System.out::println);
    }


    //5. DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test5() {
//		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);

        System.out.println(strDate);

        LocalDateTime newLdt = ldt.parse(strDate, dtf);
        System.out.println(newLdt);
    }
}
