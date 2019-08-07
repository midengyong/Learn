package com.lrfc.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrfc.shiro.entity.SysRolePermission;
import com.lrfc.shiro.mapper.SysRolePermissionMapper;
import com.lrfc.shiro.service.SysRolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Title:       [shiro — SysRolePermission模块]
 * Description: [SysRolePermission类信息的service层实现类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public IPage<SysRolePermission> selectPageWithParam(Page<SysRolePermission> page, SysRolePermission sysRolePermission){
		QueryWrapper<SysRolePermission> entityWrapper = new QueryWrapper<>(sysRolePermission);
		IPage<SysRolePermission> sysRolePermissionPage  = page(page,entityWrapper);
		if (sysRolePermissionPage.getCurrent()>sysRolePermissionPage.getPages()){
		    page.setCurrent(sysRolePermissionPage.getPages());
            sysRolePermissionPage = page(page,entityWrapper);
		}
		return  sysRolePermissionPage;
    }

    @Override
    public int addSysRolePermission(SysRolePermission sysRolePermission) {
		Integer insert = sysRolePermissionMapper.insert(sysRolePermission);
		return insert;
    }

    @Override
    public int updateSysRolePermission(SysRolePermission sysRolePermission) {
		Integer update = sysRolePermissionMapper.updateById(sysRolePermission);
		return update;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
		Integer deleteBatchIds = sysRolePermissionMapper.deleteBatchIds(ids);
		return deleteBatchIds;
    }

    @Override
    public SysRolePermission findById(Integer id) {
    SysRolePermission sysRolePermission = sysRolePermissionMapper.selectById(id);
    return sysRolePermission;
    }

	@Override
	public List<String> findPermissionByRoles(Set<String> roles) {
		return sysRolePermissionMapper.findPermissionByRoles(roles);
	}

	@Override
	public int cleanRolePermission() {
		return sysRolePermissionMapper.cleanRolePermission();
	}

}
