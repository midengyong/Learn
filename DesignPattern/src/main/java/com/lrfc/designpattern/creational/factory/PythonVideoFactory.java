package com.lrfc.designpattern.creational.factory;

/**
 * Title:       [Learn — 设计模式]
 * Description: [python视频工厂]
 * Created on   2019年06月26日
 *
 * @author 来日方长
 * @version db.0
 */
public class PythonVideoFactory extends VideoFactory{
	@Override
	public Video getVideo() {
		return new PythonVideo();
	}
}
