package com.jcohy.sample.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 2022.0.1 2022/7/22:14:39
 * @since 2022.0.1
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 模拟3个停车位
        Semaphore semaphore = new Semaphore(3);
        // 6个车
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒钟离开车位");

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
