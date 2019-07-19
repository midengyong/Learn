package com.lrfc.designpattern.structural.proxy.dynamicproxy;

import com.lrfc.designpattern.structural.proxy.Order;
import com.lrfc.designpattern.structural.proxy.db.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title:       [Learn — 设计模式]
 * Description: [订单服务动态代理]
 * Created on   2019年07月12日
 *
 * @author 来日方长
 * @version v1.0
 */
@Slf4j
public class OrderServiceDynamicProxy implements InvocationHandler {

	private Object target;
	public OrderServiceDynamicProxy(Object target){
		this.target = target;
	}
	public Object bind(){
		Class clazz = target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object argObject = args[0];
		beforeMethod(argObject);
		Object object = method.invoke(target,args);
		afterMethod();
		return object;
	}

	private void beforeMethod(Object obj){
		int userId = 0;
		log.info("动态代理 before code");
		if (obj instanceof Order){
			Order  order = (Order) obj;
			userId = order.getUserId();
		}

		int dbRouter = userId % 2;
		log.info("动态代理分配到【db{}】处理数据",dbRouter);

		//todo 设置datasource
		DataSourceContextHolder.setDbType(String.valueOf(dbRouter));
	}
	private void afterMethod(){
		log.info("动态代理 after code");
	}
}
