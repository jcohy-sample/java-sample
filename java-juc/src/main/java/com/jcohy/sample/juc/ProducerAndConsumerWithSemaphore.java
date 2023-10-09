package com.jcohy.sample.juc;

import java.util.concurrent.Semaphore;

/**
 * 描述: .
 *
 * <p>
 * Copyright © 2023 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 *
 * @author jiac
 * @version 1.0.0 2023/10/9 17:56
 * @since 1.0.0
 */
public class ProducerAndConsumerWithSemaphore {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // 缓冲区大小为5

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }


    static class Buffer {
        private final int capacity;
        private final Semaphore emptySlots;
        private final Semaphore fullSlots;
        private final int[] buffer;
        private int in = 0;
        private int out = 0;

        public Buffer(int capacity) {
            this.capacity = capacity;
            buffer = new int[capacity];
            emptySlots = new Semaphore(capacity);
            fullSlots = new Semaphore(0);
        }

        public void produce(int data) throws InterruptedException {
            emptySlots.acquire(); // 获取空槽位
            buffer[in] = data;
            in = (in + 1) % capacity;
            System.out.println("Produced: " + data);
            fullSlots.release(); // 增加已满槽位数量
            Thread.sleep(1000); // 模拟生产过程
        }

        public int consume() throws InterruptedException {
            fullSlots.acquire(); // 获取有数据的槽位
            int data = buffer[out];
            out = (out + 1) % capacity;
            System.out.println("Consumed: " + data);
            emptySlots.release(); // 增加空槽位数量
            Thread.sleep(1000); // 模拟消费过程
            return data;
        }
    }

    static class Producer implements Runnable {
        private final Buffer buffer;
        private int counter = 1;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    buffer.produce(counter);
                    counter++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private final Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
