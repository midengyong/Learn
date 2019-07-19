package com.lrfc.designpattern.creational.singleton;

/**
 * Title:       [Learn — 设计模式]
 * Description: [枚举实例]
 * Created on   2019年06月27日
 *单例最佳实践
 * @author 来日方长
 * @version db.0
 */
public enum  EnumInstance {
	INSTANCE;
	private Object data;
	public Object getData(){
		return data;
	}
	public void setData(Object data){
		this.data = data;
	}
	public static EnumInstance getInstance(){
		return INSTANCE;
	}
}
