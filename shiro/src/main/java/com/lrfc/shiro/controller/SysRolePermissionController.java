package com.lrfc.shiro.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.lrfc.shiro.common.annotation.InterfaceInformation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lrfc.shiro.common.response.ResponseData;
import com.lrfc.shiro.service.SysRolePermissionService;
import com.lrfc.shiro.entity.SysRolePermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Title:       [shiro — SysRolePermission模块]
 * Description: [SysRolePermission类信息的controller层接口]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Slf4j
@RestController
@Api(value="/sysRolePermission")
@RequestMapping("/sysRolePermission")
public class SysRolePermissionController {

    @Autowired
    public SysRolePermissionService sysRolePermissionService;

    /**
     * Description:[单表分页查询]
     * @param sysRolePermission    [实体]
     * @param length  [单页大小]
     * @param pageNo  [页数]
     * @return  ResponseData
     */
    @GetMapping("/getSysRolePermissionList")
    @InterfaceInformation(target = "/sysRolePermission/getSysRolePermissionList",name = "paginationQuery",author = "lrfc")
    @ApiOperation(value="/getSysRolePermissionList", notes="获取分页列表")
    public ResponseData getSysRolePermissionList(@ApiParam(name="SysRolePermission",value="SysRolePermission 实体类")SysRolePermission sysRolePermission ,
                @RequestParam(name = "length") @ApiParam(name="length",value="页大小",defaultValue = "10")Integer length,
                @RequestParam(name = "pageNo") @ApiParam(name="pageNo",value="页数",defaultValue = "1")Integer pageNo) {
		//构造分页对象
		Page<SysRolePermission> page=new Page<>(pageNo,length);
		//查询
		IPage<SysRolePermission> sysRolePermissionPage = sysRolePermissionService.selectPageWithParam(page, sysRolePermission);

		//判断有无数据并返回
		return CollectionUtils.isEmpty(sysRolePermissionPage.getRecords()) ? ResponseData.findNoData() : ResponseData.findSuccess(sysRolePermissionPage);
    }

    /**
      * Description:[通过id获取实体信息]
      * @param id  [id]
      * @return  ResponseData
      */
    @GetMapping("/getSysRolePermissionById")
    @InterfaceInformation(target = "/sysRolePermission/getSysRolePermissionList",name = "query",author = "lrfc")
    @ApiOperation(value="/getSysRolePermissionById", notes="通过id获取SysRolePermission")
    public ResponseData getSysRolePermissionById( @RequestParam(name = "id") @ApiParam(name="id",value="SysRolePermissionID",required=true)Integer id) {
        SysRolePermission sysRolePermission = sysRolePermissionService.findById(id);
		return sysRolePermission == null ? ResponseData.findNoData() : ResponseData.findSuccess(sysRolePermission);
    }

    /**
    * Description:[通过id删除实体信息]
    * @param ids  [id]
    * @return  ResponseData
    */
    @PostMapping("/deleteSysRolePermissionByIds")
    @InterfaceInformation(target = "/sysRolePermission/getSysRolePermissionList",name = "delete",author = "lrfc")
    @ApiOperation(value="/deleteSysRolePermissionByIds", notes="通过id删除SysRolePermission")
    public ResponseData deleteSysRolePermissionByIds(@RequestBody  @ApiParam(name="id",value="SysRolePermissionID",required=true)List<Integer> ids) {
		int id = sysRolePermissionService.deleteByIds(ids);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
     * Description:[通过实体ID修改信息]
     * @param sysRolePermission  [实体信息]
     * @return  ResponseData
     */
    @PostMapping("/updateSysRolePermissionById")
    @InterfaceInformation(target = "/sysRolePermission/getSysRolePermissionList",name = "update",author = "lrfc")
    @ApiOperation(value="/updateSysRolePermissionById", notes="通过id更新SysRolePermission")
    public ResponseData updateSysRolePermissionById(@RequestBody @ApiParam(name="SysRolePermission",value="SysRolePermission 实体类")SysRolePermission sysRolePermission) {
		int id = sysRolePermissionService.updateSysRolePermission(sysRolePermission);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }

    /**
    * Description:[通过实体添加新的数据]
    * @param sysRolePermission  [实体信息]
    * @return  ResponseData
    */
	@PostMapping("/addSysRolePermission")
	@InterfaceInformation(target = "/sysRolePermission/getSysRolePermissionList",name = "insert",author = "lrfc")
    @ApiOperation(value="/addSysRolePermission", notes="添加SysRolePermission")
    public ResponseData addSysRolePermission(@RequestBody @ApiParam(name="SysRolePermission",value="SysRolePermission 实体类")SysRolePermission sysRolePermission) {
		int id = sysRolePermissionService.addSysRolePermission(sysRolePermission);
		return id == 0 ? ResponseData.OperationFailed() : ResponseData.OperationSuccess();
    }
}
