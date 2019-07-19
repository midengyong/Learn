package com.lrfc.designpattern.structural.adapter.objectadapter;

/**
 * Title:       [Learn — 设计模式]
 * Description: [适配器]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
public class Adapter implements Target {
	private Adaptee adaptee = new Adaptee();
	@Override
	public void request() {
		//...
		adaptee.adapterRequest();
		//...
	}
}
