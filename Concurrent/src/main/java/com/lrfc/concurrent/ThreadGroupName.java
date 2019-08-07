package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [线程组]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ThreadGroupName {
	public static void main(String[] args){
		ThreadGroupName threadGroupName = new ThreadGroupName();
		//创建线程组
		ThreadGroup threadGroup = new ThreadGroup("group");
		//创建线程
		Thread thread1 = new Thread(threadGroup,threadGroupName.new ThreadGroup1(),"thread1");
		Thread thread2 = new Thread(threadGroup,threadGroupName.new ThreadGroup1(),"thread2");

		//启动线程
		thread1.start();
		thread2.start();
		threadGroup.list();
		//当前组内的线程数
		log.info("当前组内的线程数:"+threadGroup.activeCount()+"");
		//当前组内的线程列表
		threadGroup.list();

	}
	class ThreadGroup1 implements Runnable{

		@Override
		public void run() {
			log.info("线程名："+Thread.currentThread().getName());
		}
	}
}
