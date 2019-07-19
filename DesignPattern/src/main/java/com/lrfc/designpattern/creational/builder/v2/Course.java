package com.lrfc.designpattern.creational.builder.v2;

import lombok.Data;

/**
 * Title:       [Learn — 设计模式]
 * Description: [课程]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
@Data
public class Course {
	private String courseName;
	private String coursePPT;
	private String courseVideo;
	private String courseArticle;

	//问答
	private String courseQA;
	public Course(CourseBuilder courseBuilder){
		this.courseQA = courseBuilder.courseQA;
		this.courseArticle = courseBuilder.courseArticle;
		this.courseName = courseBuilder.courseName;
		this.coursePPT = courseBuilder.coursePPT;
		this.courseVideo = courseBuilder.courseVideo;
	}

	public static class CourseBuilder{
		private String courseName;
		private String coursePPT;
		private String courseVideo;
		private String courseArticle;
		private String courseQA;



		public CourseBuilder builderCourseNmae(String courseName) {
			this.courseName = courseName;
			return this;
		}

		public CourseBuilder builderCoursePPT(String coursePPT) {
			this.coursePPT = coursePPT;
			return this;
		}

		public CourseBuilder builderCourseVideo(String courseVideo) {
			this.courseVideo = courseVideo;
			return this;
		}

		public CourseBuilder builderCourseArticle(String courseArticle) {
			this.courseArticle = courseArticle;
			return this;
		}

		public CourseBuilder builderCourseQA(String courseQA) {
			this.courseQA = courseQA;
			return this;
		}
		public  Course builder(){
			return new Course(this);
		}
	}
}
