package com.lrfc.designpattern.creational.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [python课程笔记]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class PythonArticle extends Article {
	@Override
	public void produce() {
		log.info("编写Python课程笔记");
	}
}
