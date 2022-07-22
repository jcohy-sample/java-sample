package com.jcohy.sample.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Copyright : 2017- www.jcohy.com Created by jcohy on 10:59 2019/4/18 Email:
 * jia_chao23@126.com ClassName: ReadWriteLockDemo2 Description:
 **/

// 资源类
class MyCache {

	private volatile Map<String, Object> map = new HashMap<>();

	private ReadWriteLock rwLock = new ReentrantReadWriteLock();

	public void put(String key, Object value) {

		rwLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t 正在写入: " + key);
			try {
				TimeUnit.MICROSECONDS.sleep(300);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			map.put(key, value);
			System.out.println(Thread.currentThread().getName() + "\t 写入完成 ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			rwLock.writeLock().unlock();
		}
	}

	public void get(String key) {

		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t 正在读取: " + key);
			try {
				TimeUnit.MICROSECONDS.sleep(300);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			Object result = map.get(key);
			System.out.println(Thread.currentThread().getName() + "\t 读取完成:  " + result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			rwLock.readLock().unlock();
		}
	}

}

/**
 * 多个线程同时读一个资源类时没有问题,所以为了满足并发量，读取共享资源应该可以同时进行 但是如果一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或者写 总结:
 * 读-读 共存 读-写 不能共存 写-写 不能共存 写操作: 原子+独占
 */

public class ReadWriteLockDemo2 {

	public static void main(String[] args) {
		MyCache myCache = new MyCache();

		for (int i = 0; i <= 5; i++) {
			final int tempInt = i;
			new Thread(() -> {
				myCache.put(tempInt + "", tempInt);
			}, String.valueOf(i)).start();
		}

		for (int i = 0; i <= 5; i++) {
			final int tempInt = i;
			new Thread(() -> {
				myCache.get(tempInt + "");
			}, String.valueOf(i)).start();
		}
	}

}

// 输出
// 5	 正在写入: 5
// 5	 写入完成
// 4	 正在写入: 4
// 4	 写入完成
// 1	 正在写入: 1
// 1	 写入完成
// 2	 正在写入: 2
// 2	 写入完成
// 0	 正在写入: 0
// 0	 写入完成
// 3	 正在写入: 3
// 3	 写入完成
// 1	 正在读取: 1
// 2	 正在读取: 2
// 0	 正在读取: 0
// 3	 正在读取: 3
// 4	 正在读取: 4
// 5	 正在读取: 5
// 2	 读取完成:  2
// 3	 读取完成:  3
// 5	 读取完成:  5
// 4	 读取完成:  4
// 1	 读取完成:  1
// 0	 读取完成:  0
