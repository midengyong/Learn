package com.lrfc.designpattern.structural.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [礼物改变服务]
 * Created on   2019年06月28日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class GiftExchangeService {

	private PointsPaymentService pointsPaymentService = new PointsPaymentService();
	private  QualifyService qualifyService = new QualifyService();
	private ShoppingService shoppingService = new ShoppingService();

	public void setPointsPaymentService(PointsPaymentService pointsPaymentService){
		this.pointsPaymentService = pointsPaymentService;
	}
	public void setQualifyService(QualifyService qualifyService){
		this.qualifyService = qualifyService;
	}
	public void setShoppingService(ShoppingService shoppingService){
		this.shoppingService = shoppingService;
	}

	public void giftExchange(PointsGift pointsGift){
		if (qualifyService.isAvailable(pointsGift)){
			if (pointsPaymentService.pay(pointsGift)){
				String shopGift = shoppingService.shopGift(pointsGift);
				log.info("成功："+shopGift);
			}
		}
	}
}
