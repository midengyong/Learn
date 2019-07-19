package com.lrfc.designpattern.creational.simplefactory;



import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [python学习视频]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class PythonVideo extends Video {
	@Override
	public void produce() {
		log.info("录制Python课程视频");
	}
}
