package com.lrfc.designpattern.structural.adapter.classadapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [具体目标]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class ConcreteTarget implements Target{

	@Override
	public void request() {
		log.info("ConcreteTarget目标方法");
	}
}
