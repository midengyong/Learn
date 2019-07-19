package com.lrfc.designpattern.structural.proxy.dynamicproxy;

import com.lrfc.designpattern.structural.proxy.IOrderService;
import com.lrfc.designpattern.structural.proxy.IOrderServiceImpl;
import com.lrfc.designpattern.structural.proxy.Order;
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
		Order order = new Order();
		order.setUserId(2);

		IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new IOrderServiceImpl()).bind();
		orderServiceDynamicProxy.saveOrder(order);
	}

}
