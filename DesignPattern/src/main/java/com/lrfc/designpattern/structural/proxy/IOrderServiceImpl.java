package com.lrfc.designpattern.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [orderService实现]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class IOrderServiceImpl implements IOrderService {
	private IOrderDao iOrderDao;
	@Override
	public int saveOrder(Order order) {
		iOrderDao = new IOrderDaoImpl();
		log.info("IOrderService调用IOrderDao层方法");
		return iOrderDao.insert(order);
	}
}
