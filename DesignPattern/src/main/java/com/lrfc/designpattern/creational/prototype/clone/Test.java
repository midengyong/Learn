package com.lrfc.designpattern.creational.prototype.clone;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Date;

/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		LocalDate localDate = LocalDate.now();
		Pig pig = new Pig("小猪佩奇",new Date(0l));
		Pig pig1 = (Pig) pig.clone();
		log.info(pig+"");
		log.info(pig1+"");

		pig.getBirthday().setTime(6666l);

		log.info(pig+"");
		log.info(pig1+"");



	}

}
