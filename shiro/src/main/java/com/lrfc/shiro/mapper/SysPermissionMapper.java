package com.lrfc.shiro.mapper;

import com.lrfc.shiro.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的持久层]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */


@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
	int cleanPermission();

	int addSysPermissionById(SysPermission sysPermission);

}
