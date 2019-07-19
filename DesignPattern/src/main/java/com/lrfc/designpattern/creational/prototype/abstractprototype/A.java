package com.lrfc.designpattern.creational.prototype.abstractprototype;

/**
 * Title:       [Learn — 设计模式]
 * Description: [克隆父类]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
public abstract class A implements Cloneable {
	public A(){}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
