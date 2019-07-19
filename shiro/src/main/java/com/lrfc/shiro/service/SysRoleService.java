package com.lrfc.shiro.service;

import com.lrfc.shiro.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * Title:       [shiro — SysRole模块]
 * Description: [SysRole类信息的service层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
public interface SysRoleService extends IService<SysRole> {
	IPage<SysRole> selectPageWithParam(Page<SysRole> page,SysRole param);

	int addSysRole(SysRole sysRole);

	int updateSysRole(SysRole sysRole);

	int deleteByIds(List<Integer> ids);

    SysRole findById(Integer id);
}
