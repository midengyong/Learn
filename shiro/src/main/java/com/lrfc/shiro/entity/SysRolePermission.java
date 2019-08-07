package com.lrfc.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Title:       [shiro — SysRolePermission模块]
 * Description: [SysRolePermission类信息的实体类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRolePermission extends Model<SysRolePermission> implements Cloneable{

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer rId;

    /**
     * 权限id
     */
    private Integer pId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
