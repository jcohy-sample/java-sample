package com.jcohy.sample.java12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/18:12:20
 * @since 2022.0.1
 */
public class OtherTest {

    // tag::compact[]
    @Test
    void compact() {
        var cnf = NumberFormat.getCompactNumberInstance(Locale.CHINA,
                Style.SHORT);
        //1万
        System.out.println(cnf.format(1_0000));
        //2万
        System.out.println(cnf.format(1_9200));
        //100万
        System.out.println(cnf.format(1_000_000));
        //11亿
        System.out.println(cnf.format(1L << 30));
        //1兆
        System.out.println(cnf.format(1L << 40));
        //1126兆
        System.out.println(cnf.format(1L << 50));
    }
    // end::compact[]
}
