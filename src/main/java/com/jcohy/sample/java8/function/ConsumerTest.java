package com.jcohy.sample.java8.function;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/9:15:45
 * @since 2022.0.1
 */
public class ConsumerTest {

    // tag::consumer1[]
    public void happy(double money, Consumer consumer) {
        consumer.accept(money);
    }

    @Test
    void consumer1() {
        // result: 吃饭花费了2.0元
        happy(2,(x) -> System.out.println("吃饭花费了" + x +"元"));
    }
    // end::consumer1[]
}
