package com.jcohy.sample.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: .
 * <p>
 * 一、i++ 的原子性问题: i++ 的操作实际上分为三个步骤 "读-改-写"
 *          int i = 10;
 *          i = i++; //10
 *
 *          int temp = i;
 *          i = i + 1;
 *          i = temp;
 *
 * 二、原子变量: 在 java.util.concurrent.atomic 包下提供了一些原子变量.
 *        1. volatile 保证内存可见性
 *        2. CAS(Compare-And-Swap) 算法保证数据变量的原子性
 *           CAS 算法是硬件对于并发操作的支持
 *           CAS 包含了三个操作数:
 *           ①内存值  V
 *           ②预估值  A
 *           ③更新值  B
 *           当且仅当 V == A 时, V = B; 否则,不会执行任何操作.
 *
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/21:16:24
 * @since 2022.0.1
 */
public class AtomicDemo implements Runnable {

    private AtomicInteger serialNumber = new AtomicInteger(0);

    public static void main(String[] args) {
        AtomicDemo demo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo).start();
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}
