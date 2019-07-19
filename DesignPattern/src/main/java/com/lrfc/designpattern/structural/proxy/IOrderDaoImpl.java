package com.lrfc.designpattern.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [orderDao实现]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class IOrderDaoImpl implements IOrderDao {
	@Override
	public int insert(Order order) {
		log.info("添加order成功");
		return 1;
	}
}
