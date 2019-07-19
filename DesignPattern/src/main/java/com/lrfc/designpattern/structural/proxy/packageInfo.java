package com.lrfc.designpattern.structural.proxy;

/**

 * Title:       [Learn — 设计模式]
 * Description: [代理模式]
 * Created on   2019年06月26日
 * @author 来日方长
 * @version db.0
 */
public class packageInfo {
	/**
	 *  为其他对象提供一种代理，以控制对这个对象的访问
	 *  代理对象在客户端和目标对象之间起到中介的作用
	 *  类型：
	 *      结构型模式
	 *
	 *  适用场景：
	 *      保护目标对象
	 *      增强目标对象
	 *
	 *  优点：
	 *      代理模式能见将代理对象与真实被调用的目标对象分离
	 *      一定程度上降低了系统的耦合，扩展性好
	 *      保护目标对象
	 *      增强目标对象
	 *
	 *  缺点：
	 *      代理模式会造成系统设计中类的数量增加
	 *      在客户端与目标对象之间增加一个代理对象，会造成请求处理速度变慢
	 *      增加系统复杂度
	 *
	 *  扩展：
	 *      静态代理
	 *      动态代理(无法代理类，只能代理接口)
	 *      CGLib代理
	 *
	 *
	 *  spring代理选择-扩展：
	 *      当bean有接口实现时，就会使用JDK的动态代理
	 *      当bean没有实现接口时，spring使用CGLib
	 *      可以强制使用CGLib
	 *          在spring配置中加入<aop:aspectj-autoproxy proxy-target-class="true"/>
	 *
	 *  代理速度对比：
	 *      CGLib：
	 *      JDK动态代理：
	 *
	 *
	 *  相关设计模式：
	 *      代理模式和装饰者模式
	 *      代理模式和适配器模式
	 *
	 */
}
