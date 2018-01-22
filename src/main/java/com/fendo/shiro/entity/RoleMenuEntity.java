package com.fendo.shiro.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: fendo
 * @className: RoleEntity
 * @packageName: com.fendo.shiro.node
 * @description: 角色-菜单
 * @data: 2018-01-15 19:59
 **/
@TableName("sys_role_menu")
public class RoleMenuEntity extends Model<RoleMenuEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="id", type= IdType.AUTO)
    private  Integer id;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 菜单ID
     */
    private String menuId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoleMenuEntity{" +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
