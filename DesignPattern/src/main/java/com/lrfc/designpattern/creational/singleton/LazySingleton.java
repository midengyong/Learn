package com.lrfc.designpattern.creational.singleton;

/**
 * Title:       [Learn — 设计模式]
 * Description: [懒汉式--线程不安全]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
public class LazySingleton {
	private static LazySingleton lazySingleton = null;
	private LazySingleton(){

	}
	public static LazySingleton getInstance(){
		if (lazySingleton == null){
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}
}
