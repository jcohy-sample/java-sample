package com.jcohy.sample.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:16:08
 * @since 2022.0.1
 */
public class CreateStream {

    // tag::createStreamByList[]
    @Test
    void createStreamByList() {
        List<String> list = new ArrayList<>();
        // 获取一个顺序流
        Stream<String> stream = list.stream();
        // 获取一个并行流
        Stream<String> stringStream = list.parallelStream();
    }
    // end::createStreamByList[]

    // tag::createStreamByArray[]
    @Test
    void createStreamByArray() {
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);
    }
    // end::createStreamByArray[]

    // tag::createStreamByValue[]
    @Test
    void createStreamByValue() {
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
    }
    // end::createStreamByValue[]

    // tag::createStreamByFunction[]
    @Test
    void createStreamByFunction() {
        /**
         * 迭代
         * 0
         * 2
         * 4
         * 6
         * 8
         * 10
         * 12
         * 14
         * 16
         * 18
         */

        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        /**
         * 生成
         * 0.41472306051950014
         * 0.7297578581709128
         */
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);
    }
    // end::createStreamByFunction[]
}
