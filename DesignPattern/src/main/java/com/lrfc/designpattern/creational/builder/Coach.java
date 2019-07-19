package com.lrfc.designpattern.creational.builder;

/**
 * Title:       [Learn — 设计模式]
 * Description: [教练]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
public class Coach {
	private CourseBuilder courseBuilder;
	public void setCourseBuilder(CourseBuilder courseBuilder){
		this.courseBuilder = courseBuilder;
	}

	public Course makeCourse(String courseName,String coursePPT,String courseVideo,String courseArticle,String courseQA){
		this.courseBuilder.builderCourseArticle(courseArticle);
		this.courseBuilder.builderCourseNmae(courseName);
		this.courseBuilder.builderCoursePPT(coursePPT);
		this.courseBuilder.builderCourseQA(courseQA);
		this.courseBuilder.builderCourseVideo(courseVideo);
		return this.courseBuilder.makeCourse();
	}
}
