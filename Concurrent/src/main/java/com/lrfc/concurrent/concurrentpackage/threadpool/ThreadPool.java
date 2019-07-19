package com.lrfc.concurrent.concurrentpackage.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Title:       [Learn — 模块名]
 * Description: [线程池]
 * Created on   2019年06月17日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ThreadPool {
	public static void main(String[] args ){
		ThreadPool threadPool = new ThreadPool();
		ThreadPool1 threadPool1 = threadPool.new ThreadPool1();

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

//		for (int i=0;i<10;i++){
//			//10个任务，分两批执行，每批5个线程执行，执行完后复用。
//			executorService.submit(threadPool1);
//		}
		//延时线程，初始化5秒后执行
//		scheduledExecutorService.schedule(threadPool1,5, TimeUnit.SECONDS);
		//延时线程，初始化5秒后执行，从执行开始计算，3秒后再次执行
//		scheduledExecutorService.scheduleAtFixedRate(threadPool1,5,3, TimeUnit.SECONDS);
		//延时线程，初始化5秒后执行，从执行完毕后计算，3秒后再次执行
		scheduledExecutorService.scheduleWithFixedDelay(threadPool1,5,3, TimeUnit.SECONDS);
		log.info(String.valueOf(LocalDateTime.now()));


	}


	class ThreadPool1 implements Runnable{

		@Override
		public void run() {
			try {
				log.info(Thread.currentThread().getName()+":执行"+String.valueOf(LocalDateTime.now()));
				Thread.sleep(1000);
				log.info(Thread.currentThread().getName()+":执行时为"+String.valueOf(LocalDateTime.now()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
