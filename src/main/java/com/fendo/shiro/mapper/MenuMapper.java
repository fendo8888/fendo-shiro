/**
 * projectName: fendo-plus-boot
 * fileName: MenuMapper.java
 * packageName: com.fendo.shiro.mapper
 * date: 2018-01-15 20:36
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fendo.shiro.common.node.zTreeNode;
import com.fendo.shiro.entity.MenuEntity;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MenuMapper
 * @packageName: com.fendo.shiro.mapper
 * @description: 菜单表
 * @data: 2018-01-15 20:36
 **/
public interface MenuMapper extends BaseMapper<MenuEntity> {

    /**
     * 根据角色获取菜单
     * @param roleIds
     * @return
     */
    List<MenuEntity> selectMenusByRoleIds(List<String> roleIds);

    /**
     * 获取所有菜单
     * @return
     */
    List<zTreeNode> menuTreeList();
}
