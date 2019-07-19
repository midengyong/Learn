package com.lrfc.shiro.service;

import com.lrfc.shiro.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的service层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
public interface SysPermissionService extends IService<SysPermission> {
	IPage<SysPermission> selectPageWithParam(Page<SysPermission> page,SysPermission param);

	int addSysPermission(SysPermission sysPermission);

	int updateSysPermission(SysPermission sysPermission);

	int deleteByIds(List<Integer> ids);

    SysPermission findById(Integer id);
}
