package com.lrfc.designpattern.structural.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [积分支付服务]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class PointsPaymentService {
	public boolean pay(PointsGift pointsGift){
		log.info("支付"+pointsGift.getName());
		return true;
	}
}
