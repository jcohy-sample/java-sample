package com.jcohy.sample.java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:47
 * @since 2022.0.1
 */
public class SupplierTest {

    // tag::supplier[]
    //获取指定个数数字
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>(3);
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void supplier() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            /**
             * result:
             * 27
             * 57
             * 73
             * 13
             * 84
             * 49
             * 70
             * 99
             * 93
             * 65
             */
            System.out.println(integer);
        }
    }
    // end::supplier[]

    @Test
    void teste() {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(10 >> 4);
        System.out.println(Integer.toBinaryString(10 >> 4));
        System.out.println(10 << 4);
        System.out.println(Integer.toBinaryString(10 << 4));
    }
}
