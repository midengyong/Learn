package com.lrfc.designpattern.structural.decorator.v2;

/**
 * Title:       [Learn — 设计模式]
 * Description: [香肠装饰类]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
public class SausageDecorator extends AbstractDecorator {
	public SausageDecorator(ABattercake aBattercake) {
		super(aBattercake);
	}

	@Override
	protected String getDesc() {
		return super.getDesc()+"加一根香肠";
	}

	@Override
	protected int cost() {
		return super.cost()+2;
	}
}
