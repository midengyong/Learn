package com.lrfc.concurrent.concurrentpackage.reentrantreadwritelock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:       [Learn — 模块名]
 * Description: [读写锁]
 * Created on   2019年06月14日
 * @author 米邓勇
 * @version db.0
 */
@Slf4j
public class ReentrantReadWriteLock {
	//定义重入锁
	private static ReentrantLock reentrantLock = new ReentrantLock();
	//定义读写锁
	private static java.util.concurrent.locks.ReentrantReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
	//定义读锁
	private static Lock readLock = readWriteLock.readLock();
	//定义写锁
	private static Lock writeLock = readWriteLock.writeLock();
	private static int value = 0;
	//0：执行重入锁，约25秒执行完毕；1：执行读写锁,约6秒执行完毕
	private static int flag = 0;

	public static void main(String[] args ) {
		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
		Read read = reentrantReadWriteLock.new Read();
		Write write = reentrantReadWriteLock.new Write();
		Runnable readRunnable = new Runnable() {
			@Override
			public void run() {
				if (flag == 0){
					read.handleRead(reentrantLock);
				}else
					read.handleRead(readLock);
			}
		};

		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				if (flag == 0){
					write.handleWrite(value+1,reentrantLock);
				}else
					write.handleWrite(value+1,writeLock);
			}
		};

		for (int i=0;i<20;i++){
			Thread thread = new Thread(readRunnable);
			thread.start();
		}
		for (int i= 20;i<25;i++){
			Thread thread = new Thread(writeRunnable);
			thread.start();
		}
	}


	class Read {
		public Object handleRead(Lock lock){
			int num = 0;
			try {
				lock.lock();//加重入锁或者读锁
				Thread.sleep(1000);//读操作耗时1秒
				log.info(Thread.currentThread().getName()+"read");
				num = value;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			return num;
		}
	}

	class Write {
		public void handleWrite(Object o,Lock lock){
			try {
				lock.lock();//加重入锁或者写锁
				Thread.sleep(1000);//写操作耗时1秒
				log.info(Thread.currentThread().getName()+"write");
				value = (int) o;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
	}
}
