package com.lrfc.designpattern.structural.facade;


import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [进行测试]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class Test {

	public static void main(String[] args){
		PointsGift pointsGift = new PointsGift("来日方长");
		GiftExchangeService giftExchangeService = new GiftExchangeService();
//		giftExchangeService.setPointsPaymentService(new PointsPaymentService());
//		giftExchangeService.setQualifyService(new QualifyService());
//		giftExchangeService.setShoppingService(new ShoppingService());
		giftExchangeService.giftExchange(pointsGift);
		log.info("-----------------------");
	}

}
