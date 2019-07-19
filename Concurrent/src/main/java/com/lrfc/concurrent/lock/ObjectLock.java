package com.lrfc.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [对象锁]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ObjectLock {
	//静态是属于类的，所有线程共用一个;而非静态的则是属于实例的，所有线程不一定共用一个
	static ObjectLock objectLock = new ObjectLock();
	static int value = 0;
	public static void main(String[] args) throws InterruptedException {
		//创建线程
		Thread thread1 = new Thread(objectLock.new ObjectLock1());
		Thread thread2 = new Thread(objectLock.new ObjectLock1());

		//启动线程
		thread1.start();
		thread2.start();

		//等待线程执行完成后才继续执行主线程
		thread1.join();
		thread2.join();
		log.info("value:"+value);

	}

	class ObjectLock1 implements Runnable{
		@Override
		public void run() {
				for(int i=0;i<100;i++){
					synchronized (objectLock){
						log.info("线程名："+Thread.currentThread().getName());
						value++;
					}
				}
		}
	}

}
