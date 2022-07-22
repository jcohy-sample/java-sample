package com.jcohy.sample.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为 A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。
 *	如: ABCABCABC…… 依次递归
 */
public class ABCAlternateDemo {

	public static void main(String[] args) {
		AlternateDemo ad = new AlternateDemo();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 20; i++) {
					ad.loopA(i);
				}

			}
		}, "A").start();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 20; i++) {
					ad.loopB(i);
				}

			}
		}, "B").start();

		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i <= 20; i++) {
					ad.loopC(i);

					System.out.println("-----------------------------------");
				}

			}
		}, "C").start();
	}

}

class AlternateDemo {

	private int number = 1; // 当前正在执行线程的标记

	private Lock lock = new ReentrantLock();

	private Condition condition1 = lock.newCondition();

	private Condition condition2 = lock.newCondition();

	private Condition condition3 = lock.newCondition();

	/**
	 * @param totalLoop : 循环第几轮
	 */
	public void loopA(int totalLoop) {
		lock.lock();

		try {
			// 1. 判断
			if (number != 1) {
				condition1.await();
			}

			// 2. 打印
			for (int i = 1; i <= 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}

			// 3. 唤醒
			number = 2;
			condition2.signal();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

	public void loopB(int totalLoop) {
		lock.lock();

		try {
			// 1. 判断
			if (number != 2) {
				condition2.await();
			}

			// 2. 打印
			for (int i = 1; i <= 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}

			// 3. 唤醒
			number = 3;
			condition3.signal();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}

	public void loopC(int totalLoop) {
		lock.lock();

		try {
			// 1. 判断
			if (number != 3) {
				condition3.await();
			}

			// 2. 打印
			for (int i = 1; i <= 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}

			// 3. 唤醒
			number = 1;
			condition1.signal();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	// 输出
	// A	1	1
	// B	1	1
	// C	1	1
	// -----------------------------------
	// A	1	2
	// B	1	2
	// C	1	2
	// -----------------------------------
	// A	1	3
	// B	1	3
	// C	1	3
	// -----------------------------------
	// A	1	4
	// B	1	4
	// C	1	4
	// -----------------------------------
	// A	1	5
	// B	1	5
	// C	1	5
	// -----------------------------------
	// A	1	6
	// B	1	6
	// C	1	6
	// -----------------------------------
	// A	1	7
	// B	1	7
	// C	1	7
	// -----------------------------------
	// A	1	8
	// B	1	8
	// C	1	8
	// -----------------------------------
	// A	1	9
	// B	1	9
	// C	1	9
	// -----------------------------------
	// A	1	10
	// B	1	10
	// C	1	10
	// -----------------------------------
	// A	1	11
	// B	1	11
	// C	1	11
	// -----------------------------------
	// A	1	12
	// B	1	12
	// C	1	12
	// -----------------------------------
	// A	1	13
	// B	1	13
	// C	1	13
	// -----------------------------------
	// A	1	14
	// B	1	14
	// C	1	14
	// -----------------------------------
	// A	1	15
	// B	1	15
	// C	1	15
	// -----------------------------------
	// A	1	16
	// B	1	16
	// C	1	16
	// -----------------------------------
	// A	1	17
	// B	1	17
	// C	1	17
	// -----------------------------------
	// A	1	18
	// B	1	18
	// C	1	18
	// -----------------------------------
	// A	1	19
	// B	1	19
	// C	1	19
	// -----------------------------------
	// A	1	20
	// B	1	20
	// C	1	20
	// -----------------------------------

}
