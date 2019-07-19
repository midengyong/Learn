package com.lrfc.designpattern.structural.proxy.staticproxy;

import com.lrfc.designpattern.structural.proxy.IOrderService;
import com.lrfc.designpattern.structural.proxy.IOrderServiceImpl;
import com.lrfc.designpattern.structural.proxy.Order;
import com.lrfc.designpattern.structural.proxy.db.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [订单Service静态代理]
 * Created on   2019年07月11日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class OrderServiceStaticProxy {
	private IOrderService orderService;

	public int saveOrder(Order order) {
		beforeMethod(order);
		orderService = new IOrderServiceImpl();
		int result = orderService.saveOrder(order);
		afterMethod();
		return result;
	}

	private void beforeMethod(Order order){
		log.info("静态代理 before code");

		int userId = order.getUserId();
		int dbRouter = userId % 2;
		log.info("静态代理分配到【db{}】处理数据",dbRouter);

		//todo 设置datasource
		DataSourceContextHolder.setDbType(String.valueOf(dbRouter));
	}
	private void afterMethod(){
		log.info("静态代理 after code");
	}

}
