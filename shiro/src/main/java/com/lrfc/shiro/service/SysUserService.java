package com.lrfc.shiro.service;

import com.lrfc.shiro.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * Title:       [shiro — SysUser模块]
 * Description: [SysUser类信息的service层接口]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */
public interface SysUserService extends IService<SysUser> {
	IPage<SysUser> selectPageWithParam(Page<SysUser> page,SysUser param);

	int addSysUser(SysUser sysUser);

	int updateSysUser(SysUser sysUser);

	int deleteByIds(List<Integer> ids);

    SysUser findById(Integer id);
}
