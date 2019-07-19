package com.lrfc.designpattern.creational.factory;

/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
public class Test {
	public static void main(String[] args) {
		VideoFactory videoFactory = new JavaVideoFactory();
		Video video = videoFactory.getVideo();
		video.produce();
		videoFactory = new PythonVideoFactory();
		Video video1 = videoFactory.getVideo();
		video1.produce();
	}
}
