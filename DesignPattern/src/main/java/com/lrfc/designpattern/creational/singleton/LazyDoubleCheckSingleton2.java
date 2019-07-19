package com.lrfc.designpattern.creational.singleton;

/**
 * Title:       [Learn — 设计模式]
 * Description: [懒加载双检锁]
 * Created on   2019年06月27日
 *基于静态内部类
 * @author 来日方长
 * @version db.0
 */
public class LazyDoubleCheckSingleton2 {
	private LazyDoubleCheckSingleton2(){
		if (InnerClassSingleton.lazyDoubleCheckSingleton2 != null)
			throw new RuntimeException("单例模式不能进行反射调用");
	}
	private static class InnerClassSingleton{
		private static LazyDoubleCheckSingleton2 lazyDoubleCheckSingleton2 = new LazyDoubleCheckSingleton2();
	}
	public static LazyDoubleCheckSingleton2 getInstance(){
		return InnerClassSingleton.lazyDoubleCheckSingleton2;
	}
}
