package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [等待和唤醒]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class WaitAndNotify {
	private static Object object = new Object();

	public static void main(String[] args) throws InterruptedException {
		WaitAndNotify waitAndNotify = new WaitAndNotify();
		Thread thread1 = new Thread(waitAndNotify.new WaitAndNotify1());
		Thread thread2 = new Thread(waitAndNotify.new WaitAndNotify2());

		log.info("main");
		thread1.start();
		Thread.sleep(3000);
		thread2.start();


	}

	class WaitAndNotify1 implements Runnable{

		@Override
		public void run() {
				synchronized (object){
					log.info(Thread.currentThread().getName()+"运行");
					try {
						log.info(Thread.currentThread().getName()+"等待");
						object.wait();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info(Thread.currentThread().getName()+"结束");
					Thread.yield();
				}
		}
	}
	class WaitAndNotify2 implements Runnable{

		@Override
		public void run() {
				synchronized (object){
					log.info(Thread.currentThread().getName()+"运行");

					log.info(Thread.currentThread().getName()+"唤醒其他线程");
					object.notify();

					try {
						log.info(Thread.currentThread().getName()+"等待");
						Thread.sleep(2000);
//					object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info(Thread.currentThread().getName()+"结束");
					Thread.yield();
				}
		}
	}
}
