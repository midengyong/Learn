package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [挂起和继续执行]
 * Created on   2019年06月13日
 *
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class SuspendAndResume {
	private static Object object = new Object();
	public static void main(String[] args) throws InterruptedException {
		SuspendAndResume suspendAndResume = new SuspendAndResume();
		//创建线程
		Thread thread1 = new Thread(suspendAndResume.new SuspendAndResume1());
		Thread thread2 = new Thread(suspendAndResume.new SuspendAndResume1());

		//启动线程
		thread1.start();
		Thread.sleep(2000);
		thread2.start();

		//程序不会退出，而是挂起
		thread1.resume();
		thread2.resume();

		log.info(Thread.currentThread().getName()+"线程执行");
		thread1.join();
		thread2.join();
		log.info("线程已被阻塞，此打印不会被执行");


	}
	class SuspendAndResume1 implements Runnable{

		@Override
		public void run() {
			synchronized (object){
				log.info("in"+Thread.currentThread().getName());
				Thread.currentThread().suspend();
			}
		}
	}
}
