package com.lrfc.designpattern.creational.builder.v2;

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
	public static void main(String[] args) {
		Course course = new Course.CourseBuilder()
				.builderCourseNmae("java入门到放弃")
				.builderCoursePPT("入门")
				.builderCourseArticle("笔记")
				.builderCourseVideo("c://")
				.builder();
		log.info(course.toString());

	}
}
