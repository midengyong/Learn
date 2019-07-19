package com.lrfc.designpattern.structural.facade;

import lombok.Data;

/**
 * Title:       [Learn — 设计模式]
 * Description: [积分礼物]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Data
public class PointsGift {
	private String  name;
	public PointsGift(String  name){
		this.name = name;
	}
}
