package com.lrfc.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * Title:       [Learn — 设计模式]
 * Description: [饿汉式]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
public class HungrySingleton implements Serializable {
	private  HungrySingleton(){
		if (hungrySingleton != null)
			throw new RuntimeException("单例模式不能进行反射调用");
	}
	private final static  HungrySingleton hungrySingleton;

	static {
		hungrySingleton= new HungrySingleton();
	}
	public static HungrySingleton getInstance(){
		return hungrySingleton;
	}

	//序列化与反序列化使用
	private Object readResolve(){
		return hungrySingleton;
	}
}
