package com.lrfc.designpattern.creational.builder;

/**
 * Title:       [Learn — 设计模式]
 * Description: [课程建造者]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
public abstract class CourseBuilder {
	public abstract void builderCourseNmae(String courseName);
	public abstract void builderCoursePPT(String coursePPT);
	public abstract void builderCourseVideo(String courseVideo);
	public abstract void builderCourseArticle(String courseArticle);
	public abstract void builderCourseQA(String courseQA);

	public abstract Course makeCourse();
}

