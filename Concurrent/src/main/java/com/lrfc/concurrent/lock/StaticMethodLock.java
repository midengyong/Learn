package com.lrfc.concurrent.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 模块名]
 * Description: [静态方法锁]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class StaticMethodLock {

	static int value = 0;
	public static void main(String[] args) throws InterruptedException {
		//创建线程
		Thread thread1 = new Thread(new StaticMethodLock1());
		Thread thread2 = new Thread(new StaticMethodLock1());

		//启动线程
		thread1.start();
		thread2.start();

		//等待线程执行完成后才继续执行主线程
		thread1.join();
		thread2.join();
		log.info("value:"+value);

	}


	static class StaticMethodLock1 implements Runnable{
		public static synchronized  void add(){
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
