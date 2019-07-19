package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 模块名]
 * Description: [守护线程]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class DeamonThread {
	public static void main(String[] args) throws InterruptedException {
		DeamonThread deamonThread = new DeamonThread();
		//创建线程
		Thread thread1 = new Thread(deamonThread.new DeamonThread1());
		//设置为守护线程，且必须设置在start()之前；如果没有设置为守护线程，则此线程将无线循环打印
		thread1.setDaemon(true);
		//启动线程
		thread1.start();
		//主线程运行完成后程序停止
		log.info("main");
		Thread.sleep(2000);
	}

	class DeamonThread1 implements Runnable{

		@Override
		public void run() {
			while (true){
				log.info("线程名："+Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
