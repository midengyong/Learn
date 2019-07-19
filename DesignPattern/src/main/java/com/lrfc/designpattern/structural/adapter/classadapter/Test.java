package com.lrfc.designpattern.structural.adapter.classadapter;


import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Test {

	public static void main(String[] args){
		Target target = new ConcreteTarget();
		target.request();

		Target target1 = new Adapter();
		target1.request();
	}

}
