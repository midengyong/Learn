package com.lrfc.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrfc.shiro.common.enums.Constant;
import com.lrfc.shiro.common.exception.AccountException;
import com.lrfc.shiro.common.exception.ResourceException;
import com.lrfc.shiro.common.exception.RoleException;
import com.lrfc.shiro.common.utils.PasswordUtils;
import com.lrfc.shiro.config.menu.CustomListenerProcessor;
import com.lrfc.shiro.config.menu.CustomMenu;
import com.lrfc.shiro.config.menu.Menu;
import com.lrfc.shiro.entity.*;
import com.lrfc.shiro.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:       [Learn — Shiro]
 * Description: [扫描自定义InterfaceInformation注解值]
 * Created on   2019年05月20日
 *
 * @author 米邓勇
 * @version v1.0
 */
@Component
@Slf4j
public class CustomCommandLineRunner implements CommandLineRunner {
	@Value("${custom.isAddMenu}")
	private boolean isAddMenu;
	@Value("${custom.system.role}")
	private String roleName;
	@Value("${custom.system.account.create}")
	private boolean create;
	@Value("${custom.system.account.default-account}")
	private String account;
	@Value("${custom.system.account.default-name}")
	private String nickName;
	@Value("${custom.system.account.default-pwd}")
	private String pwd;

	@Autowired
	private CustomMenu customMenu;

	@Autowired
	private SysPermissionService sysPermissionService;
	@Autowired
	private SysRolePermissionService sysRolePermissionService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;


	@Transactional
	@Override
	public void run(String... args) throws Exception {
		//是否执行资源表数据初始化
		if (isAddMenu){
			log.info("执行资源表数据初始化");

			boolean cleanData = cleanData();
			if (!cleanData)
				throw new ResourceException("资源数据清除失败");
			log.info("资源数据清除成功");


			//对资源进行存储
			boolean saveBatch = savePermissionData();
			if (!saveBatch)
				throw new ResourceException("资源表数据初始化失败");
			log.info("资源表数据初始化成功");

			SysRole sysRole = findSysRole();
			saveRolePermissionData(sysRole);

			if (create){
				saveAccount(sysRole);
			}


		}
	}

	private void saveAccount(SysRole sysRole){
		log.info("保存系统用户并与系统角色关联");
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("account",roleName);
		SysUser sysUser = sysUserService.getOne(queryWrapper);
		if (sysUser == null){
			sysUser.setModifier("system");
			sysUser.setModifyTime(LocalDateTime.now());
			sysUser.setAccount(account);
			sysUser.setIsDeleted(Constant.IS_DELETED_N.getValue());
			sysUser.setIsLock(Constant.IS_DELETED_N.getValue());
			sysUser.setName(nickName);
			PasswordUtils passwordUtils = new PasswordUtils();
			passwordUtils.encryptPassword(sysUser);
			boolean save = sysUserService.save(sysUser);
			if (!save)
				throw new AccountException("新建系统帐户失败");
		}
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUId(sysUser.getId());
		sysUserRole.setRId(sysRole.getId());
		QueryWrapper<SysUserRole> sysUserRoleQueryWrapper = new QueryWrapper<>(sysUserRole);
		SysUserRole userRoleServiceOne = sysUserRoleService.getOne(sysUserRoleQueryWrapper);
		if (userRoleServiceOne == null) {
			boolean save = sysUserRoleService.save(sysUserRole);
			if (!save)
				throw new AccountException("系统帐户与系统角色绑定失败");
		}

	}

	/**
	 * Description:[绑定系统角色与所有资源的关联关系]
	 * date: 2019-8-7 11:30
	 * @author: 米邓勇
	 * @param sysRole [系统角色]
	 * @return : void
	 */
	private void saveRolePermissionData(SysRole sysRole){
		log.info("保存系统角色与所有资源的关联");
		SysRolePermission sysRolePermissionTemp = new SysRolePermission();
		sysRolePermissionTemp.setRId(sysRole.getId());

		List<SysPermission> sysPermissions = sysPermissionService.list();

		List<SysRolePermission> sysRolePermissions = new ArrayList<>();
		if (!CollectionUtils.isEmpty(sysPermissions)){
			for (SysPermission sysPermission1: sysPermissions){
				SysRolePermission sysRolePermission = null;
				try {
					sysRolePermission = (SysRolePermission) sysRolePermissionTemp.clone();
					sysRolePermission.setPId(sysPermission1.getId());
					sysRolePermissions.add(sysRolePermission);
				} catch (CloneNotSupportedException e) {
					log.error("实体SysRolePermission克隆失败");
					e.printStackTrace();
				}
			}

			boolean saveBatch = sysRolePermissionService.saveBatch(sysRolePermissions);
			if (!saveBatch)
				throw new ResourceException("系统角色与资源绑定失败");
		}

	}

	/**
	 * Description:[查询配置的系统用户是否存在，不存在则创建]
	 * date: 2019-8-7 11:31
	 * @author: 米邓勇
	 * @return : SysRole
	 */
	private SysRole findSysRole(){
		log.info("查询默认系统角色是否存在,如果不存在则新建角色");
		QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name",roleName);
		SysRole sysRole = sysRoleService.getOne(queryWrapper);
		if (sysRole == null){
			sysRole = new SysRole();
			sysRole.setName(roleName);
			sysRole.setIsDeleted(Constant.IS_DELETED_N.getValue());
			sysRole.setModifier("system");
			sysRole.setModifyTime(LocalDateTime.now());
			sysRole.setRemark("这是一个系统角色");
			boolean save = sysRoleService.save(sysRole);
			if (!save)
				throw new RoleException("新建系统角色失败");
		}
		return sysRole;
	}
	/**
	 * Description:[保存菜单以及按钮资源]
	 * date: 2019-8-7 11:31
	 * @author: 米邓勇
	 * @return : boolean
	 */
	private boolean savePermissionData(){
		List<SysPermission> permissions = CustomListenerProcessor.permissions;
		List<Menu> menus = customMenu.getMenu();
		SysPermission sysPermission = new SysPermission();
		sysPermission.setIsDeleted(Constant.IS_DELETED_N.getValue());
		sysPermission.setModifyTime(LocalDateTime.now());
		for (Menu menu:menus){
			SysPermission permission;
			try {
				permission = (SysPermission) sysPermission.clone();
				permission.setId(menu.getId());
				permission.setParentId(menu.getParentId());
				permission.setType(menu.getType());
				permission.setName(menu.getName());
				permission.setModifier(menu.getAuthor());
				permission.setPermission(menu.getPermission());
				sysPermissionService.addSysPermissionById(permission);
			} catch (CloneNotSupportedException e) {
				log.error("实体SysPermission克隆失败");
				e.printStackTrace();
			}
		}
		boolean saveBatch = sysPermissionService.saveBatch(permissions);
		return saveBatch;
	}
	/**
	 * Description:[清除资源及角色资源关联数据]
	 * date: 2019-8-7 13:18
	 * @author: 米邓勇
	 * @return : boolean
	 */
	private boolean cleanData(){
		log.info("清除资源表数据及角色权限关联表数据");
		int permissionCount = sysPermissionService.count();
		int rolePermissionCount = sysRolePermissionService.count();
		if (permissionCount != 0){
			int cleanPermission = sysPermissionService.cleanPermission();
			if (permissionCount != cleanPermission)
				return false;
		}
		if (rolePermissionCount != 0){
			int cleanRolePermission = sysRolePermissionService.cleanRolePermission();
			if (rolePermissionCount != cleanRolePermission)
				return false;
		}
		return  true;

	}
}
