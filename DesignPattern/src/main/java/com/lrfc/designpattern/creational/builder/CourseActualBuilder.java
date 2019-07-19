package com.lrfc.designpattern.creational.builder;

/**
 * Title:       [Learn — 设计模式]
 * Description: [课程实际建造者]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
public class CourseActualBuilder extends CourseBuilder {
	private Course course = new Course();
	@Override
	public void builderCourseNmae(String courseName) {
		course.setCourseName(courseName);
	}

	@Override
	public void builderCoursePPT(String coursePPT) {
		course.setCoursePPT(coursePPT);
	}

	@Override
	public void builderCourseVideo(String courseVideo) {
		course.setCourseVideo(courseVideo);
	}

	@Override
	public void builderCourseArticle(String courseArticle) {
		course.setCourseArticle(courseArticle);
	}

	@Override
	public void builderCourseQA(String courseQA) {
		course.setCourseQA(courseQA);
	}

	@Override
	public Course makeCourse() {
		return course;
	}
}
