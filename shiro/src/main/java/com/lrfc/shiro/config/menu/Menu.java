package com.lrfc.shiro.config.menu;

import lombok.Data;

/**
 * Description: [权限菜单]
 * Created on   2019年08月05日
 *
 * @author 米邓勇
 * @version v1.0
 */
@Data
public class Menu {
	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 父权限id
	 */
	private Integer parentId;
	/**
	 * 权限名称
	 */
	private String name;
	/**
	 * 权限
	 */
	private String permission;
	/**
	 * 权限类型
	 */
	private int type;
	/**
	 * 作者
	 */
	private String  author;
}
