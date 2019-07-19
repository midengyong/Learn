package com.lrfc.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [方法锁]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class MethodLock {
	//静态是属于类的，所有线程共用一个;而非静态的则是属于实例的，所有线程不一定共用一个

	static int value = 0;
	public static void main(String[] args) throws InterruptedException {
		MethodLock methodLock = new MethodLock();
		//创建线程
		MethodLock1 methodLock1 = methodLock.new MethodLock1();
		Thread thread1 = new Thread(methodLock1);
		Thread thread2 = new Thread(methodLock1);

		//启动线程
		thread1.start();
		thread2.start();

		//等待线程执行完成后才继续执行主线程
		thread1.join();
		thread2.join();
		log.info("value:"+value);

	}


	class MethodLock1 implements Runnable{
		public synchronized void add(){
			log.info("线程名："+Thread.currentThread().getName());
			value++;
		}
		@Override
		public void run() {
			for(int i=0;i<100;i++){
				add();
			}
		}
	}
}
