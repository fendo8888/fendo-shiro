package com.fendo.shiro.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserRoleEntity
 * @packageName: com.fendo.shiro.node
 * @description: 用户-角色表
 * @data: 2018-01-15 19:59
 **/
@TableName("sys_user_role")
public class UserRoleEntity extends Model<UserRoleEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
