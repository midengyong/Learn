package com.lrfc.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 线程]
 * Description: [线程优先级]
 * Created on   2019年06月13日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class PriorityThread {
	public static void main(String[] args)  {
		PriorityThread priorityThread = new PriorityThread();
		//创建线程
		Thread thread1 = new Thread(priorityThread.new PriorityThreadLow(),"thread1");
		Thread thread2 = new Thread(priorityThread.new PriorityThreadLow(),"thread2");

		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.NORM_PRIORITY);
		//启动线程
		thread1.start();
		thread2.start();
	}

	class PriorityThreadLow implements Runnable{
		volatile int i = 0;
		@Override
		public void run() {
			while (true){
				synchronized (PriorityThread.class){
					i++;
					log.info("线程名："+Thread.currentThread().getName()+",value:"+i);
					if (i>100)
						break;
				}
			}
		}
	}
}
