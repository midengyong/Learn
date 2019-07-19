package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [等待线程结束和谦让]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class JoinAndYield {
	private Object object = new Object();
	private static volatile int value = 0;
	public static void main(String[] args) throws InterruptedException {
		JoinAndYield joinAndYield = new JoinAndYield();
		//创建线程
		Thread thread1 = new Thread(joinAndYield.new JoinAndYield1());
		Thread thread2 = new Thread(joinAndYield.new JoinAndYield1());

		//启动线程
		thread1.start();
		thread2.start();


		log.info(Thread.currentThread().getName()+"线程执行");
		//使主线程等待thread1，thread2两个线程执行完毕
		thread1.join();
		thread2.join();
		log.info(Thread.currentThread().getName()+value);


	}

	class JoinAndYield1 implements Runnable{

		@Override
		public void run() {
			synchronized (object){
				for (value=0;value<10;value++){
					log.info(Thread.currentThread().getName()+"执行，结果为："+value);
					//对于此方法理解不够，不知道适用于那种场景，如何使用
					Thread.yield();
				}
			}
		}
	}
}
