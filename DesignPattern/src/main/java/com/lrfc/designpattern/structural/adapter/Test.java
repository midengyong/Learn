package com.lrfc.designpattern.structural.adapter;


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
		DC5 dc5 = new PowerAdapter();
		dc5.outputDC5V();
	}

}
