package com.lrfc.designpattern.structural.decorator.v2;

/**
 * Title:       [Learn — 设计模式]
 * Description: [煎饼]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
public class Battercake extends ABattercake{

	@Override
	protected String getDesc() {
		return "煎饼";
	}

	@Override
	protected int cost() {
		return 8;
	}
}
