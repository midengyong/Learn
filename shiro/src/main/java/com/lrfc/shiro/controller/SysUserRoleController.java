package com.lrfc.shiro.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrfc.shiro.common.response.ResponseData;
import com.lrfc.shiro.service.SysUserRoleService;
import com.lrfc.shiro.entity.SysUserRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Title:       [shiro — SysUserRole模块]
 * Description: [SysUserRole类信息的controller层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@RestController
@Api(value="/sysUserRole")
@RequestMapping("/sysUserRole")
public class SysUserRoleController {

    @Autowired
    public SysUserRoleService sysUserRoleService;

    /**
     * Description:[单表分页查询]
     * @param sysUserRole    [实体]
     * @param length  [单页大小]
     * @param pageNo  [页数]
     * @return  ResponseData
     */
    @GetMapping("/getSysUserRoleList")
    @InterfaceInformation(target = "/sysUserRole/getSysUserRoleList",name = "paginationQuery",author = "lrfc")
    @ApiOperation(value="/getSysUserRoleList", notes="获取分页列表")
    public ResponseData getSysUserRoleList(@ApiParam(name="SysUserRole",value="SysUserRole 实体类")SysUserRole sysUserRole ,
                @RequestParam(name = "length") @ApiParam(name="length",value="页大小",defaultValue = "10")Integer length,
                @RequestParam(name = "pageNo") @ApiParam(name="pageNo",value="页数",defaultValue = "1")Integer pageNo) {
		//构造分页对象
		Page<SysUserRole> page=new Page<>(pageNo,length);
		//查询
		IPage<SysUserRole> sysUserRolePage = sysUserRoleService.selectPageWithParam(page, sysUserRole);

		//判断有无数据并返回
		return CollectionUtils.isEmpty(sysUserRolePage.getRecords()) ? ResponseData.findNoData() : ResponseData.findSuccess(sysUserRolePage);
    }

    /**
      * Description:[通过id获取实体信息]
      * @param id  [id]
      * @return  ResponseData
      */
    @GetMapping("/getSysUserRoleById")
    @InterfaceInformation(target = "/sysUserRole/getSysUserRoleList",name = "query",author = "lrfc")
    @ApiOperation(value="/getSysUserRoleById", notes="通过id获取SysUserRole")
    public ResponseData getSysUserRoleById( @RequestParam(name = "id") @ApiParam(name="id",value="SysUserRoleID",required=true)Integer id) {
        SysUserRole sysUserRole = sysUserRoleService.findById(id);
		return sysUserRole == null ? ResponseData.findNoData() : ResponseData.findSuccess(sysUserRole);
    }

    /**
    * Description:[通过id删除实体信息]
    * @param ids  [id]
    * @return  ResponseData
    */
    @PostMapping("/deleteSysUserRoleByIds")
    @InterfaceInformation(target = "/sysUserRole/getSysUserRoleList",name = "delete",author = "lrfc")
    @ApiOperation(value="/deleteSysUserRoleByIds", notes="通过id删除SysUserRole")
    public ResponseData deleteSysUserRoleByIds(@RequestBody  @ApiParam(name="id",value="SysUserRoleID",required=true)List<Integer> ids) {
		int id = sysUserRoleService.deleteByIds(ids);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
     * Description:[通过实体ID修改信息]
     * @param sysUserRole  [实体信息]
     * @return  ResponseData
     */
    @PostMapping("/updateSysUserRoleById")
    @InterfaceInformation(target = "/sysUserRole/getSysUserRoleList",name = "update",author = "lrfc")
    @ApiOperation(value="/updateSysUserRoleById", notes="通过id更新SysUserRole")
    public ResponseData updateSysUserRoleById(@RequestBody @ApiParam(name="SysUserRole",value="SysUserRole 实体类")SysUserRole sysUserRole) {
		int id = sysUserRoleService.updateSysUserRole(sysUserRole);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
    * Description:[通过实体添加新的数据]
    * @param sysUserRole  [实体信息]
    * @return  ResponseData
    */
	@PostMapping("/addSysUserRole")
	@InterfaceInformation(target = "/sysUserRole/getSysUserRoleList",name = "insert",author = "lrfc")
    @ApiOperation(value="/addSysUserRole", notes="添加SysUserRole")
    public ResponseData addSysUserRole(@RequestBody @ApiParam(name="SysUserRole",value="SysUserRole 实体类")SysUserRole sysUserRole) {
		int id = sysUserRoleService.addSysUserRole(sysUserRole);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }
}
