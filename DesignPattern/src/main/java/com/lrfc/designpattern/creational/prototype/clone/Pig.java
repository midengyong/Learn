package com.lrfc.designpattern.creational.prototype.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Title:       [Learn — 设计模式]
 * Description: [小猪]
 * Created on   2019年06月27日
 *
 * @author 来日方长
 * @version db.0
 */
@Data
@AllArgsConstructor
public class Pig implements  Cloneable{
	private String name;
	private Date birthday;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Pig pig = (Pig) super.clone();

		//深克隆
		pig.birthday = (Date) pig.getBirthday().clone();
		return pig;
	}
}
