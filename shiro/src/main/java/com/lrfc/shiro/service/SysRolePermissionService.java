package com.lrfc.shiro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lrfc.shiro.entity.SysRolePermission;

import java.util.List;
import java.util.Set;

/**
 * Title:       [shiro — SysRolePermission模块]
 * Description: [SysRolePermission类信息的service层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {
	IPage<SysRolePermission> selectPageWithParam(Page<SysRolePermission> page,SysRolePermission param);

	int addSysRolePermission(SysRolePermission sysRolePermission);

	int updateSysRolePermission(SysRolePermission sysRolePermission);

	int deleteByIds(List<Integer> ids);

    SysRolePermission findById(Integer id);

	List<String> findPermissionByRoles(Set<String> roles);

	/**
	 * Description:[清空数据]
	 * date: 2019-8-7 10:30
	 * @return : void
	 */
	int cleanRolePermission();
}
