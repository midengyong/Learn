package com.lrfc.designpattern.structural.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Title:       [Learn — 设计模式]
 * Description: [校验服务]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class QualifyService {
	public boolean isAvailable(PointsGift pointsGift){
		log.info("校验:"+pointsGift.getName());
		return true;
	}
}
