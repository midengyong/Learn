package com.lrfc.designpattern.structural.adapter.objectadapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: []
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Adaptee {
	public void adapterRequest(){
		log.info("被适配者的方法");
	}
}
