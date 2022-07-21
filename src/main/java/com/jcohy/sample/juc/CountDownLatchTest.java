package com.jcohy.sample.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/21:18:21
 * @since 2022.0.1
 */
public class CountDownLatchTest {
    // 主线程等待子线程执行完成再执行
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        final CountDownLatch latch = new CountDownLatch(3);
        for(int i = 0; i< 3; i++ ) {
            service.execute(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                    Thread.sleep((long)Math.random() * 1000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    // 当前线程调用此方法，计数减一
                    latch.countDown();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }

        System.out.println("主线程" + Thread.currentThread().getName() + "等待子线程执行完毕。。。。");
        latch.await();
        System.out.println("主线程" + Thread.currentThread().getName() + "开始执行");
    }
}
