package com.lrfc.concurrent.concurrentpackage.reentrylock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:       [Learn — 线程]
 * Description: [重入锁与Condition]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ReentryLockCondition {
	//添加重入锁，用来替代synchronized关键字
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	public static void main(String[] args ) throws InterruptedException {
		ReentryLockCondition reentryLock = new ReentryLockCondition();
		Thread thread1 = new Thread(reentryLock.new ReentryLockCondition1());

		thread1.start();

		log.info("等待2秒后执行");
		Thread.sleep(2000);

		lock.lock();
		condition.signal();
		lock.unlock();

	}

	class ReentryLockCondition1 implements Runnable{
		@Override
		public void run() {
			try {
				lock.lock();
				condition.await();
				log.info(Thread.currentThread().getName()+"执行");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
}
