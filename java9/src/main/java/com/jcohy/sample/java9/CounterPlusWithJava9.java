package com.jcohy.sample.java9;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/11:17:58
 * @since 2022.0.1
 */
public class CounterPlusWithJava9 {
    private static int count = 0;

    public static void increment() throws IllegalAccessException, NoSuchFieldException {
        VarHandle countHandle = MethodHandles.privateLookupIn(CounterPlusWithJava9.class, MethodHandles.lookup())
                .findStaticVarHandle(CounterPlusWithJava9.class, "count", int.class);
        countHandle.getAndAdd(1);
    }

    public static int get() {
        return count;
    }

    public static void main(String[] args) {
        int threadNum = 500;
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(() -> {
                try {
                    CounterPlusWithJava9.increment();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            });
        }
        for (Thread t : threads) {
            t.start();
            try {
                t.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(CounterPlusWithJava9.get());
    }
}
