package com.lrfc.concurrent.concurrentpackage.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title:       [Learn — 模块名]
 * Description: [倒计数器]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class CountDownLatchDemo {
	private static CountDownLatch countDownLatch = new CountDownLatch(10);
	public static void main(String[] args) throws InterruptedException {
		CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		CountDownLatchDemo1 countDownLatchDemo1 = countDownLatchDemo.new CountDownLatchDemo1();
		for (int i=0;i<10;i++){
			executorService.execute(countDownLatchDemo1);
		}

		countDownLatch.await();
		log.info("await");

		executorService.shutdown();
	}

	class CountDownLatchDemo1 implements Runnable{
		@Override
		public void run() {
			log.info(Thread.currentThread().getName()+"check");
			try {
				Thread.sleep(1000);
				countDownLatch.countDown();
				log.info(Thread.currentThread().getName()+"execute");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
