package com.jcohy.sample.java8.date;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime.toString());      //2022-07-13T00:58:22.315248
		System.out.println(localDateTime.getDayOfMonth()); //13
		System.out.println(localDateTime.getHour());       //0
		System.out.println(localDateTime.getNano());       //315248000
    }
}
