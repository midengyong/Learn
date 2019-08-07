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
 * Title:       [shiro — SysUser模块]
 * Description: [SysUser类信息的实体类]
 * Created on   2019-08-07
 * @version     V1.0
 * @author  lrfc
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser extends Model<SysUser> {

private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 是否锁定；Y:已锁定；N：未锁定
     */
    @TableField("isLock")
    private String isLock;

    /**
     * 昵称
     */
    private String name;

    /**
     * 最后修改者
     */
    private String modifier;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;

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
