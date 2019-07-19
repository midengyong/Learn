package com.lrfc.concurrent.concurrentpackage.reentrylock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:       [Learn — 线程]
 * Description: [重入锁-响应中断]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ReentryLockInterruptibly {
	//添加重入锁，用来替代synchronized关键字
	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();


	public static void main(String[] args ) throws InterruptedException {
		ReentryLockInterruptibly reentryLock = new ReentryLockInterruptibly();
		Thread thread1 = new Thread(reentryLock.new ReentryLockInterruptibly1(1),"thread1");
		Thread thread2 = new Thread(reentryLock.new ReentryLockInterruptibly1(2),"thread2");

		thread1.start();
		thread2.start();

		Thread.sleep(2000);
		//中断线程thread2
		thread2.interrupt();
	}


	class ReentryLockInterruptibly1 implements Runnable{
		public int num ;
		public ReentryLockInterruptibly1(int num){
			this.num = num;
		}
		@Override
		public void run() {
			try {
				if (num == 1){
						lock1.lockInterruptibly();
						Thread.sleep(5000);
						lock2.lockInterruptibly();
				}else if (num == 2){
						lock2.lockInterruptibly();
						Thread.sleep(5000);
						lock1.lockInterruptibly();
				}
				log.info(Thread.currentThread().getName()+"执行");
			}catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				if (lock1.isHeldByCurrentThread())
					lock1.unlock();
				if (lock2.isHeldByCurrentThread())
					lock2.unlock();
			}
			log.info(Thread.currentThread().getName()+"退出");
		}
	}
}
