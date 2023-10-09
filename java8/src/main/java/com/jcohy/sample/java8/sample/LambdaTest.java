package com.jcohy.sample.java8.sample;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:18:19
 * @since 2022.0.1
 */
public class LambdaTest {

    @Test
    public void test1() {
        Integer[] arrays = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(arrays)
                .map((x) -> x * x)
                .collect(Collectors.toList())
                /**
                 * result:
                 * 1
                 * 4
                 * 9
                 * 16
                 * 25
                 */
                .forEach(System.out::println);
    }
}
