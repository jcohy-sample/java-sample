package com.jcohy.sample.java8.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:17:59
 * @since 2022.0.1
 */
public class TestForkJoin {

    @Test
    public void test1() {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);

        long sum = pool.invoke(task);
        // result: -5340232216128654848
        System.out.println(sum);

        long end = System.currentTimeMillis();
        // result: 耗费的时间为: 3625
        System.out.println("耗费的时间为: " + (end - start)); //112-1953-1988-2654-2647-20663-113808
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();

        long sum = 0L;

        for (long i = 0L; i <= 10000000000L; i++) {
            sum += i;
        }

        // result: -5340232216128654848
        System.out.println(sum);

        long end = System.currentTimeMillis();
        // result: 耗费的时间为: 6376
        System.out.println("耗费的时间为: " + (end - start)); //34-3174-3132-4227-4223-31583
    }

    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        Long sum = LongStream.rangeClosed(0L, 10000000000L)
                .parallel()
                .sum();

        // result: -5340232216128654848
        System.out.println(sum);

        long end = System.currentTimeMillis();

        // result: 耗费的时间为: 2428
        System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926
    }

}
