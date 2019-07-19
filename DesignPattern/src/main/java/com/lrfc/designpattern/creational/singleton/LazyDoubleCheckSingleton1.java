package com.lrfc.designpattern.creational.singleton;

/**
 * Title:       [Learn — 设计模式]
 * Description: [懒加载双检锁]
 * Created on   2019年06月27日
 *不允许指令重排序
 * @author 来日方长
 * @version db.0
 */
public class LazyDoubleCheckSingleton1 {
	private static volatile LazyDoubleCheckSingleton1 lazyDoubleCheckSingleton1 = null;
	private LazyDoubleCheckSingleton1(){

	}
	public static LazyDoubleCheckSingleton1 getInstance(){
		if (lazyDoubleCheckSingleton1 == null){
			synchronized (LazyDoubleCheckSingleton1.class){
				if (lazyDoubleCheckSingleton1 == null){
					lazyDoubleCheckSingleton1 = new LazyDoubleCheckSingleton1();
					//1.分配内存
					//2.初始化对象
					//3.设置LazyDoubleCheckSingleton 指向分配到内存地址
				}
			}
		}
		return lazyDoubleCheckSingleton1;
	}
}
