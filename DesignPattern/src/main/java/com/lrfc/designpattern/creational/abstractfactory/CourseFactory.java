package com.lrfc.designpattern.creational.abstractfactory;

/**
 * Title:       [Learn — 设计模式]
 * Description: [课程工厂]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
public interface CourseFactory {
	Video getVideo();
	Article getArticle();
}
