package com.lrfc.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的实体类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission extends Model<SysPermission> {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限地址
     */
    private String url;

    /**
     * 父权限id
     */
    private Integer parentId;

    /**
     * 权限
     */
    private String permission;

    /**
     * 是否已删除；Y:已删除；N：未删除
     */
    @TableField("isDeleted")
    @TableLogic
    private String isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
