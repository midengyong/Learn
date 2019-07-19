package com.lrfc.designpattern.creational.simplefactory;


/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
public class Test {
	public static void main(String[] args) {
		VideoFactory videoFactory = new VideoFactory();
		Video video = videoFactory.getVideo(JavaVideo.class);
		if (video == null){
			return;
		}
		video.produce();
		Video video1 = videoFactory.getVideo(PythonVideo.class);
		if (video1 == null){
			return;
		}
		video1.produce();

	}
}
