package com.lrfc.concurrent.concurrentpackage.reentrylock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:       [Learn — 线程]
 * Description: [重入锁-限时等待]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ReentrantLockWaitTime {
	//添加重入锁，用来替代synchronized关键字
	private static ReentrantLock lock = new ReentrantLock();
	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();
	public static void main(String[] args ) throws InterruptedException {
		ReentrantLockWaitTime reentryLock = new ReentrantLockWaitTime();

		//重入锁限时5秒
		log.info("重入锁限时5秒");
		Thread thread1 = new Thread(reentryLock.new ReentrantLockWaitTime1(),"thread1");
		Thread thread2 = new Thread(reentryLock.new ReentrantLockWaitTime1(),"thread2");

		thread1.start();
		thread2.start();

		//重入锁不限时，循环执行，直到成功
		log.info("重入锁不限时，循环执行，直到成功");
		Thread thread3 = new Thread(reentryLock.new ReentrantLockWaitTime2(1),"thread3");
		Thread thread4 = new Thread(reentryLock.new ReentrantLockWaitTime2(2),"thread4");

		thread3.start();
		thread4.start();

	}



	class ReentrantLockWaitTime1 implements Runnable{
		@Override
		public void run() {
			try {
				if (lock.tryLock(5, TimeUnit.SECONDS)){
					log.info(Thread.currentThread().getName()+"获取锁成功");
					Thread.sleep(6000);
				}else {
					log.info(Thread.currentThread().getName()+"获取锁失败");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if (lock.isHeldByCurrentThread())
					lock.unlock();
			}
		}
	}

	class ReentrantLockWaitTime2 implements Runnable{
		private int num;
		public  ReentrantLockWaitTime2(int num){
			this.num = num;
		}
		@Override
		public void run() {
			if (num == 1){
				while (true){
					try {//使成功获取两个锁的几率更高
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (lock1.tryLock()){
						try {
							log.info(Thread.currentThread().getName()+"获取锁lock1");
							Thread.sleep(1000);
							if (lock2.tryLock()){
								try {
									log.info(Thread.currentThread().getName()+"执行成功");
									return;
								}finally {
									lock2.unlock();
								}
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {
							log.info(Thread.currentThread().getName()+"释放锁lock1");
							lock1.unlock();
						}
					}
				}
			}else if (num == 2){
				while (true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (lock2.tryLock()){
						try {
							log.info(Thread.currentThread().getName()+"获取锁lock2");
							Thread.sleep(1001);
							if (lock1.tryLock()){
								try {
									log.info(Thread.currentThread().getName()+"执行成功了");
									return;
								}finally {
									lock1.unlock();
								}
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						} finally {
							log.info(Thread.currentThread().getName()+"释放锁lock2");
							lock2.unlock();
						}
					}
				}
			}
		}
	}
}
