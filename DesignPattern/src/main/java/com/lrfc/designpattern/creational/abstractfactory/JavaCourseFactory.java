package com.lrfc.designpattern.creational.abstractfactory;

/**
 * Title:       [Learn — 设计模式]
 * Description: [java课程工厂]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
public class JavaCourseFactory implements CourseFactory {
	@Override
	public Video getVideo() {
		return new JavaVideo();
	}

	@Override
	public Article getArticle() {
		return new JavaArticle();
	}
}
