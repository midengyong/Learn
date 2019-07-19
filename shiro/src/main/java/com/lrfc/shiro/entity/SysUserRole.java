package com.lrfc.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Title:       [shiro — SysUserRole模块]
 * Description: [SysUserRole类信息的实体类]
 * Created on   2019-07-18
 * @version     V1.0
 * @author  lrfc
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserRole extends Model<SysUserRole> {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 角色id
     */
    private Integer rId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
