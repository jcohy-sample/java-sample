package com.jcohy.sample.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * 1. ReadWriteLock : 读写锁
 *
 * 写写/读写 需要 "互斥"
 * 读读 不需要互斥
 *
 */
public class ReadWriteLockDemo {

	public static void main(String[] args) {
		ReadWriteLockDemoTest rw = new ReadWriteLockDemoTest();

		new Thread(() -> rw.set((int) (Math.random() * 101)), "Write:").start();

		for (int i = 0; i < 100; i++) {
			new Thread(() -> rw.get()).start();
		}
	}

}

class ReadWriteLockDemoTest {

	private int number = 0;

	private ReadWriteLock lock = new ReentrantReadWriteLock();

	// 读
	public void get() {
		lock.readLock().lock(); // 上锁

		try {
			System.out.println(Thread.currentThread().getName() + " : " + number);
		}
		finally {
			lock.readLock().unlock(); // 释放锁
		}
	}

	// 写
	public void set(int number) {
		lock.writeLock().lock();

		try {
			System.out.println(Thread.currentThread().getName());
			this.number = number;
		}
		finally {
			lock.writeLock().unlock();
		}
	}

}
