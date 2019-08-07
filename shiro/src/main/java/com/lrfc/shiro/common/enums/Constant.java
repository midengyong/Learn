package com.lrfc.shiro.common.enums;

/**
 * Description: [常量类]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public enum Constant {
	SHIRO_LOGIN_FAILURE("shiroLoginFailure"),
	IS_DELETED_Y("Y"),
	IS_DELETED_N("N");


	Constant(String value){
		this.value = value;
	}
	private String  value;

	public String getValue() {
		return value;
	}
}
