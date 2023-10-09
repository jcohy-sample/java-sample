package com.jcohy.sample.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description: 线程顺序执行，使用 Lock 和 Condition
 *
 * @author jiac
 * @version 2023.0.1 2023/10/9:11:00
 * @since 2023.0.1
 */
public class SequentialExecutionWithLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        var condition1 = lock.newCondition();
        var condition2 = lock.newCondition();
        var condition3 = lock.newCondition();

        var thread1 = new Thread(new Worker(lock,condition1,condition2),"Thread 1");
        var thread2 = new Thread(new Worker(lock,condition2,condition3),"Thread 2");
        var thread3 = new Thread(new Worker(lock,condition3,condition1),"Thread 3");


        try {
            // 启动所有线程
            thread1.start();
            thread2.start();
            thread3.start();

            // 唤醒第一个线程
            lock.lock();
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }

    static class Worker implements Runnable {
        private final Lock lock;

        private final Condition currentCondition;

        private final Condition nextCondition;

        public Worker(Lock lock, Condition currentCondition, Condition nextCondition) {
            this.lock = lock;
            this.currentCondition = currentCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            lock.lock();
            try {
                // 等待条件满足
                currentCondition.await();
                System.out.println("Thread " + threadName + " is running");
                Thread.sleep(1000);
                System.out.println("Thread " + threadName + " is finished");
                nextCondition.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
