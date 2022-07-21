package com.jcohy.sample.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/21:18:05
 * @since 2022.0.1
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> System.out.println("召唤神龙"));
        for(int i =1; i<= 7 ;i ++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到" + tempInt + "个龙珠");
                try {
                    cyclicBarrier.await();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }, String.valueOf(i)).start();
        }
    }
    // 输出
    // 7        收集到7个龙珠
    // 3        收集到3个龙珠
    // 5        收集到5个龙珠
    // 4        收集到4个龙珠
    // 6        收集到6个龙珠
    // 2        收集到2个龙珠
    // 1        收集到1个龙珠
    // 召唤神龙
}
