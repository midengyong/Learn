package com.lrfc.shiro.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lrfc.shiro.entity.SysUser;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Title:       [Learn — 设计模式]
 * Description: [用户信息结果封装]
 * Created on   2019年07月18日
 *
 * @author 来日方长
 * @version v1.0
 */
@Data
public class UserDto implements Serializable {
	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 账户
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 是否锁定；Y:已锁定；N：未锁定
	 */
	private String isLock;
	/**
	 * 昵称
	 */
	private String name;

	private List<String> role;

	private List<String> permission;
	//private List<Map<String,String>> permission;

	public static UserDto adapt(SysUser sysUser){
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(sysUser, userDto);
		return userDto;
	}
}
