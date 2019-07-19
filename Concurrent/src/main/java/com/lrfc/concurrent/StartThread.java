package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [启动一个线程]
 * Created on   2019年06月12日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class StartThread{
	public static void main(String[] args){
	StartThread startThread = new StartThread();
	//新建线程
	Thread thread1 = new Thread(startThread.new StartThreadImplements());
	Thread thread2 = startThread.new StartThreadExtends();
	//启动一个线程
	thread1.start();
	thread2.start();
	}


	 class  StartThreadImplements implements Runnable{

		@Override
		public void run() {
			log.info("implements Runnable");
		}
	}
	 class StartThreadExtends extends Thread{
		@Override
		public void run() {
			super.run();
			log.info(" extends Thread");
		}
	}
}
