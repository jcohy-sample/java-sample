package com.jcohy.sample.java9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:17:57
 * @since 2022.0.1
 */
public class CounterPlusWithJava8 {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        this.count.getAndIncrement();
    }

    public int get() {
        return this.count.get();
    }
}
