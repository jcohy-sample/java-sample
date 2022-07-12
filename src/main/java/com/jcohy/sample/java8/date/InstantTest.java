package com.jcohy.sample.java8.date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:07
 * @since 2022.0.1
 */
public class InstantTest {
    // Instant : 时间戳. (使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值)
    @Test
    public void test2() {
        Instant ins = Instant.now();  //默认使用 UTC 时区
        // result: 2022-07-11T03:02:32.739257200Z
        System.out.println(ins);

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        // result: 2022-07-11T11:02:32.739257200+08:00
        System.out.println(odt);
        // result: 739257200
        System.out.println(ins.getNano());

        Instant ins2 = Instant.ofEpochSecond(5);
        // result: 1970-01-01T00:00:05Z
        System.out.println(ins2);
    }
}
