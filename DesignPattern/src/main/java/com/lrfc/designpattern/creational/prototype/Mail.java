package com.lrfc.designpattern.creational.prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Title:       [Learn — 设计模式]
 * Description: [邮件类]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
@Slf4j
@Data
public class Mail implements Cloneable{
	private String name;
	private String emailAddress;
	private String content;
	public Mail(){
		log.info("mail class constructor");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		log.info("clone mail");
		return super.clone();
	}
}
