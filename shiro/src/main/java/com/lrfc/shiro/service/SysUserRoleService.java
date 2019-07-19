package com.lrfc.shiro.service;

import com.lrfc.shiro.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * Title:       [shiro — SysUserRole模块]
 * Description: [SysUserRole类信息的service层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
public interface SysUserRoleService extends IService<SysUserRole> {
	IPage<SysUserRole> selectPageWithParam(Page<SysUserRole> page,SysUserRole param);

	int addSysUserRole(SysUserRole sysUserRole);

	int updateSysUserRole(SysUserRole sysUserRole);

	int deleteByIds(List<Integer> ids);

    SysUserRole findById(Integer id);

	List<String> findRoleNameByAccount(Integer userId);
}
