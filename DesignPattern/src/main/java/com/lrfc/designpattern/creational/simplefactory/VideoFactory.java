package com.lrfc.designpattern.creational.simplefactory;

/**
 * Title:       [Learn — 设计模式]
 * Description: [视频工厂]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
public class VideoFactory {
	public Video getVideo(Class clazz){
		Video video = null;
		try {
			video = (Video) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return video;
	}
}
