package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [中止线程]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class InterruptThread {

	public static void main(String[] args) throws InterruptedException {
		InterruptThread interruptThread = new InterruptThread();
		//创建线程
		Thread thread1 = new Thread(interruptThread.new InterruptThread1());
		Thread thread2 = new Thread(interruptThread.new InterruptThread2());
		Thread thread3 = new Thread(interruptThread.new InterruptThread3());

		//启动线程
		thread1.start();
		thread2.start();
		thread3.start();

		Thread.sleep(5000);
		//使线程进入中断

		//没有对线程中断进行处理，线程将重复执行
		thread1.interrupt();
		//已经对线程中断进行处理,同时对中断产生时sleep方法产生的异常进行处理，使当前线程再次进入中断状态
		thread2.interrupt();
		//已经对线程中断进行处理，在中断产生时的sleep方法异常未进行处理，线程将重复执行
		thread3.interrupt();
	}

	class InterruptThread1 implements Runnable{

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					log.error(e.getMessage());
					e.printStackTrace();
				}
				log.info(Thread.currentThread().getName()+"线程没有对中断进行任何处理");
			}
		}
	}
	class InterruptThread2 implements Runnable{

		@Override
		public void run() {
			while (true) {
				if (Thread.currentThread().isInterrupted()){
					log.info(Thread.currentThread().getName()+"当前线程已经进入中断，进行中断操作");
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
				log.info(Thread.currentThread().getName()+"线程没有对中断进行任何处理");
				Thread.yield();
			}
		}
	}
	class InterruptThread3 implements Runnable{

		@Override
		public void run() {
			while (true) {
				if (Thread.currentThread().isInterrupted()){
					log.info(Thread.currentThread().getName()+"当前线程已经进入中断，进行中断操作");
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info(Thread.currentThread().getName()+"线程没有对中断进行任何处理");
				Thread.yield();
			}
		}
	}
}
