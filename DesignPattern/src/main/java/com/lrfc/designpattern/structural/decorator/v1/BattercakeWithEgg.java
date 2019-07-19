package com.lrfc.designpattern.structural.decorator.v1;

/**
 * Title:       [Learn — 设计模式]
 * Description: [煎饼加蛋]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
public class BattercakeWithEgg extends Battercake{
	@Override
	protected String getDesc() {
		return super.getDesc()+"加一个蛋";
	}

	@Override
	protected int cost() {
		return super.cost()+2;
	}
}
