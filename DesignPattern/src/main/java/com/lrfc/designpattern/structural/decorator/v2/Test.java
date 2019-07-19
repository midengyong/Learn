package com.lrfc.designpattern.structural.decorator.v2;


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
		ABattercake battercake;
		battercake = new Battercake();
		battercake = new EggDecorator(battercake);
		battercake = new SausageDecorator(battercake);
		log.info(battercake.getDesc()+",价格："+battercake.cost());
	}

}
