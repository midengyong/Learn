package com.lrfc.designpattern.structural.decorator.v2;

/**
 * Title:       [Learn — 设计模式]
 * Description: [抽象装饰者]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
public class AbstractDecorator extends ABattercake {
	private ABattercake aBattercake;
	public AbstractDecorator(ABattercake aBattercake){
		this.aBattercake = aBattercake;
	}
	@Override
	protected String getDesc() {
		return this.aBattercake.getDesc();
	}

	@Override
	protected int cost() {
		return this.aBattercake.cost();
	}
}
