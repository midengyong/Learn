package com.lrfc.designpattern.structural.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Title:       [Learn — 设计模式]
 * Description: [物流服务]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class ShoppingService {
	public String  shopGift(PointsGift pointsGift){
		log.info("物流："+pointsGift.getName());
		return "666";
	}

}
