package com.lrfc.designpattern.creational.factory;


import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [java课程视频]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class JavaVideo extends Video {
	@Override
	public void produce() {
		log.info("录制Java课程视频");
	}
}
