package com.lrfc.designpattern.creational.builder;

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
}
