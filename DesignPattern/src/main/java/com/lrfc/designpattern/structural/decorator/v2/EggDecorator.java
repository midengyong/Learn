package com.lrfc.designpattern.structural.decorator.v2;

/**
 * Title:       [Learn — 设计模式]
 * Description: [蛋装饰类]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
public class EggDecorator extends AbstractDecorator {
	public EggDecorator(ABattercake aBattercake) {
		super(aBattercake);
	}

	@Override
	protected String getDesc() {
		return super.getDesc()+"加一个鸡蛋";
	}

	@Override
	protected int cost() {
		return super.cost()+1;
	}
}
