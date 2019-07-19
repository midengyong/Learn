package com.lrfc.designpattern.structural.adapter.classadapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [适配器]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Adapter extends Adaptee implements Target{

	@Override
	public void request() {
		//...
		super.adapterRequest();
		//...
	}
}
