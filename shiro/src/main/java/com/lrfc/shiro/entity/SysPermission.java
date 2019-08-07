package com.lrfc.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Title:       [shiro — SysPermission模块]
 * Description: [SysPermission类信息的实体类]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission extends Model<SysPermission> implements Cloneable{

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
     * 权限类型:0:menu,1:button
     */
    private Integer type;

    /**
     * 是否已删除；Y:已删除；N：未删除
     */
    @TableField("isDeleted")
    @TableLogic
    private String isDeleted;

    /**
     * 最后修改者
     */
    private String modifier;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
