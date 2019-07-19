package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**

 * Title:       [Learn — 线程]
 * Description: [终止线程]
 * Created on   2019年06月12日
 *
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class TerminateThread {
	public static void main(String[] args) throws InterruptedException {
		TerminateThread terminateThread = new TerminateThread();
		//新建线程
		Thread thread1 = new Thread(terminateThread.new TerminateThread1());
		TerminateThread2 terminateThread2 = terminateThread.new TerminateThread2();
		Thread thread2 = new Thread(terminateThread2);
		//启动一个线程
		thread1.start();
		thread2.start();
		Thread.sleep(5000);
		log.info("main");
		//可能会废弃,不推荐使用
		thread1.stop();
		terminateThread2.stopMe();
	}
	 class TerminateThread1 implements Runnable{

		@Override
		public void run() {
			while (true){
				try {
					Thread.sleep(1000);
					log.info("stop");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	  class TerminateThread2 implements Runnable{
		volatile boolean flag = false;
		public void stopMe(){
			flag = true;
		}

		@Override
		public void run() {
			while (true){
				if (flag){
					log.info("标志位退出");
					break;
				}
				try {
					Thread.sleep(1000);
					log.info("标志位"+flag);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
