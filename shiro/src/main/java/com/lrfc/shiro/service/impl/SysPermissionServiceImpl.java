package com.lrfc.shiro.service.impl;

import com.lrfc.shiro.entity.SysPermission;
import com.lrfc.shiro.mapper.SysPermissionMapper;
import com.lrfc.shiro.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的service层实现类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public IPage<SysPermission> selectPageWithParam(Page<SysPermission> page, SysPermission sysPermission){
		QueryWrapper<SysPermission> entityWrapper = new QueryWrapper<>(sysPermission);
		IPage<SysPermission> sysPermissionPage  = page(page,entityWrapper);
		if (sysPermissionPage.getCurrent()>sysPermissionPage.getPages()){
		    page.setCurrent(sysPermissionPage.getPages());
            sysPermissionPage = page(page,entityWrapper);
		}
		return  sysPermissionPage;
    }

    @Override
    public int addSysPermission(SysPermission sysPermission) {
		Integer insert = sysPermissionMapper.insert(sysPermission);
		return insert;
    }

    @Override
    public int updateSysPermission(SysPermission sysPermission) {
		Integer update = sysPermissionMapper.updateById(sysPermission);
		return update;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
		Integer deleteBatchIds = sysPermissionMapper.deleteBatchIds(ids);
		return deleteBatchIds;
    }

    @Override
    public SysPermission findById(Integer id) {
    SysPermission sysPermission = sysPermissionMapper.selectById(id);
    return sysPermission;
    }

}
