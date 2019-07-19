package com.lrfc.shiro.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrfc.shiro.common.response.ResponseData;
import com.lrfc.shiro.service.SysRoleService;
import com.lrfc.shiro.entity.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Title:       [shiro — SysRole模块]
 * Description: [SysRole类信息的controller层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@RestController
@Api(value="/sysRole")
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    public SysRoleService sysRoleService;

    /**
     * Description:[单表分页查询]
     * @param sysRole    [实体]
     * @param length  [单页大小]
     * @param pageNo  [页数]
     * @return  ResponseData
     */
    @GetMapping("/getSysRoleList")
    @InterfaceInformation(target = "/sysRole/getSysRoleList",name = "paginationQuery",author = "lrfc")
    @ApiOperation(value="/getSysRoleList", notes="获取分页列表")
    public ResponseData getSysRoleList(@ApiParam(name="SysRole",value="SysRole 实体类")SysRole sysRole ,
                @RequestParam(name = "length") @ApiParam(name="length",value="页大小",defaultValue = "10")Integer length,
                @RequestParam(name = "pageNo") @ApiParam(name="pageNo",value="页数",defaultValue = "1")Integer pageNo) {
		//构造分页对象
		Page<SysRole> page=new Page<>(pageNo,length);
		//查询
		IPage<SysRole> sysRolePage = sysRoleService.selectPageWithParam(page, sysRole);

		//判断有无数据并返回
		return CollectionUtils.isEmpty(sysRolePage.getRecords()) ? ResponseData.findNoData() : ResponseData.findSuccess(sysRolePage);
    }

    /**
      * Description:[通过id获取实体信息]
      * @param id  [id]
      * @return  ResponseData
      */
    @GetMapping("/getSysRoleById")
    @InterfaceInformation(target = "/sysRole/getSysRoleList",name = "query",author = "lrfc")
    @ApiOperation(value="/getSysRoleById", notes="通过id获取SysRole")
    public ResponseData getSysRoleById( @RequestParam(name = "id") @ApiParam(name="id",value="SysRoleID",required=true)Integer id) {
        SysRole sysRole = sysRoleService.findById(id);
		return sysRole == null ? ResponseData.findNoData() : ResponseData.findSuccess(sysRole);
    }

    /**
    * Description:[通过id删除实体信息]
    * @param ids  [id]
    * @return  ResponseData
    */
    @PostMapping("/deleteSysRoleByIds")
    @InterfaceInformation(target = "/sysRole/getSysRoleList",name = "delete",author = "lrfc")
    @ApiOperation(value="/deleteSysRoleByIds", notes="通过id删除SysRole")
    public ResponseData deleteSysRoleByIds(@RequestBody  @ApiParam(name="id",value="SysRoleID",required=true)List<Integer> ids) {
		int id = sysRoleService.deleteByIds(ids);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
     * Description:[通过实体ID修改信息]
     * @param sysRole  [实体信息]
     * @return  ResponseData
     */
    @PostMapping("/updateSysRoleById")
    @InterfaceInformation(target = "/sysRole/getSysRoleList",name = "update",author = "lrfc")
    @ApiOperation(value="/updateSysRoleById", notes="通过id更新SysRole")
    public ResponseData updateSysRoleById(@RequestBody @ApiParam(name="SysRole",value="SysRole 实体类")SysRole sysRole) {
		int id = sysRoleService.updateSysRole(sysRole);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
    * Description:[通过实体添加新的数据]
    * @param sysRole  [实体信息]
    * @return  ResponseData
    */
	@PostMapping("/addSysRole")
	@InterfaceInformation(target = "/sysRole/getSysRoleList",name = "insert",author = "lrfc")
    @ApiOperation(value="/addSysRole", notes="添加SysRole")
    public ResponseData addSysRole(@RequestBody @ApiParam(name="SysRole",value="SysRole 实体类")SysRole sysRole) {
		int id = sysRoleService.addSysRole(sysRole);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }
}
