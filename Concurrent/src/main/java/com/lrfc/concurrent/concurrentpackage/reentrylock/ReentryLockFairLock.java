package com.lrfc.concurrent.concurrentpackage.reentrylock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:       [Learn — 线程]
 * Description: [重入锁-公平锁]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ReentryLockFairLock {
	//添加重入锁，用来替代synchronized关键字,公平锁
	private static ReentrantLock lock = new ReentrantLock(true);
	public static void main(String[] args ) throws InterruptedException {
		ReentryLockFairLock reentryLock = new ReentryLockFairLock();
		Thread thread1 = new Thread(reentryLock.new ReentryLockFairLock1(),"thread1");
		Thread thread2 = new Thread(reentryLock.new ReentryLockFairLock1(),"thread2");

		thread1.start();
		thread2.start();

	}

	class ReentryLockFairLock1 implements Runnable{

		@Override
		public void run() {
			while (true){
				lock.lock();
				try {
					Thread.sleep(1000);
					log.info(Thread.currentThread().getName()+"执行");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}
}
