package com.lrfc.concurrent.concurrentpackage.reentrylock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:       [Learn — 模块名]
 * Description: [重入锁]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ReentryLock {
	//添加重入锁，用来替代synchronized关键字
	private static ReentrantLock  lock = new ReentrantLock();
	private static int value = 0;
	public static void main(String[] args ) throws InterruptedException {
		ReentryLock reentryLock = new ReentryLock();
		Thread thread1 = new Thread(reentryLock.new ReentryLock1());
		Thread thread2 = new Thread(reentryLock.new ReentryLock1());

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		log.info("value="+value);
	}


	class ReentryLock1 implements Runnable{
		@Override
		public void run() {
			for (int i = 0;i<10000;i++){
				lock.lock();
				try {
					value++;
				}finally {
					//加锁后，不管进行什么操作，左后一点需要释放锁
					lock.unlock();
				}
			}
		}
	}

}
