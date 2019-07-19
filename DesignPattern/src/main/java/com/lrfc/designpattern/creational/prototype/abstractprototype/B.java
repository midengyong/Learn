package com.lrfc.designpattern.creational.prototype.abstractprototype;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;

/**
 * Title:       [Learn — 设计模式]
 * Description: [克隆子类]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
public class B extends A {
	private B(){
		log.info("B class constructor");
	}
	public static void main(String[] args) throws CloneNotSupportedException, ParseException {
		B b = new B();
		B b1 = (B) b.clone();
		log.info(b+"");
		log.info(b1+"");


////时间处理类
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		long currentTime = df.parse(df.format(new Date(2019,7,1,13,54,53))).getTime();
//		//从对象中拿到时间
//		long createTime = df.parse(df.format(new Date(2019,7,1,11,32,23))).getTime();
//		long diff=(currentTime-createTime)/1000/60;
//		System.out.println("当前系统时间为："+currentTime+"下单时间为："+createTime+"两个时间差为："+diff);

	}
}
