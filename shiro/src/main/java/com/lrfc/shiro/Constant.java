package com.lrfc.shiro;

/**
 * Description: [常量类]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
public enum Constant {
	SHIRO_LOGIN_FAILURE("shiroLoginFailure");

	Constant(String value){
		this.value = value;
	}
	private String  value;

	public String getValue() {
		return value;
	}
}
