package com.lrfc.concurrent.concurrentpackage.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Title:       [Learn — 线程]
 * Description: [信号量]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class SemaphoreDemo {
	private static Semaphore semaphore = new Semaphore(5,true);

	public static void main(String[] args ) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
		SemaphoreDemo1 semaphoreDemo1 = semaphoreDemo.new SemaphoreDemo1();
		for (int i = 0;i<20;i++){
			executorService.execute(semaphoreDemo1);
		}
		executorService.shutdown();
	}
	class SemaphoreDemo1 implements Runnable{
		@Override
		public void run() {
			try {
				semaphore.acquire();
				Thread.sleep(2000);
				log.info(Thread.currentThread().getName()+"获取信号量，并执行");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaphore.release();
			}
		}
	}
}
