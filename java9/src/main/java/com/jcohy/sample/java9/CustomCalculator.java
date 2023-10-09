package com.jcohy.sample.java9;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/15:18:36
 * @since 2022.0.1
 */
public interface CustomCalculator {

    default int addEvenNumbers(int... nums) {
        return add(n -> n % 2 == 0, nums);
    }

    default int addOddNumbers(int... nums) {
        return add(n -> n % 2 != 0, nums);
    }

    private int add(IntPredicate predicate, int... nums) {
        return IntStream.of(nums)
                .filter(predicate)
                .sum();
    }
}
