package com.jcohy.sample.juc;

/**
 * Copyright: Copyright (c) 2023 <a href="https://www.jcohy.com" target="_blank">jcohy.com</a>
 *
 * <p> Description: 线程顺序执行，使用 join
 *
 * @author jiac
 * @version 2023.0.1 2023/10/9:10:28
 * @since 2023.0.1
 */
public class SequentialExecutionWithJoin {
    public static void main(String[] args) {
        var thread1 = new Thread(new Worker(),"Thread1");
        var thread2 = new Thread(new Worker(),"Thread2");
        var thread3 = new Thread(new Worker(),"Thread3");


        try {
            // 启动第一个线程
            thread1.start();
            // 等待第一个线程执行完毕
            thread1.join();

            // 启动第二个线程
            thread2.start();
            // 等待第二个线程执行完毕
            thread2.join();

            // 启动第三个线程
            thread3.start();
            // 等待第三个线程执行完毕
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        var thread1 = new Thread(() -> {
//            try {
//                String threadName = Thread.currentThread().getName();
//                System.out.println("Thread " + threadName + " is running");
//                Thread.sleep(1000);
//                System.out.println("Thread " + threadName + " is finished");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        },"Thread1");
//        var thread2 = new Thread(() -> {
//            try {
//                thread1.join();
//                String threadName = Thread.currentThread().getName();
//                System.out.println("Thread " + threadName + " is running");
//                Thread.sleep(1000);
//                System.out.println("Thread " + threadName + " is finished");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        },"Thread2");
//        var thread3 = new Thread(() -> {
//            try {
//                thread2.join();
//                String threadName = Thread.currentThread().getName();
//                System.out.println("Thread " + threadName + " is running");
//                Thread.sleep(1000);
//                System.out.println("Thread " + threadName + " is finished");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        },"Thread3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }


    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("Thread " + threadName + " is running");
                Thread.sleep(1000);
                System.out.println("Thread " + threadName + " is finished");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
