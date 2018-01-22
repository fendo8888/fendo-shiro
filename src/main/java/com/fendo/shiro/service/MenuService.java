/**
 * projectName: fendo-plus-boot
 * fileName: MenuService.java
 * packageName: com.fendo.shiro.service
 * date: 2018-01-15 20:46
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.service;

import com.baomidou.mybatisplus.service.IService;
import com.fendo.shiro.common.node.TreeViewNode;
import com.fendo.shiro.common.node.zTreeNode;
import com.fendo.shiro.entity.MenuEntity;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MenuService
 * @packageName: com.fendo.shiro.service
 * @description: 菜单Service
 * @data: 2018-01-15 20:46
 **/
public interface MenuService extends IService<MenuEntity> {


    /**
     * 根据角色获取菜单
     * @param roleIds
     * @return
     */
    List<MenuEntity> selectMenusByRoleIds(List<String> roleIds);

    /**
     * 根据角色ID获取菜单
     * @param roleIds
     * @return
     */
    TreeViewNode selectTreeViewNodeByRoleId(List<String> roleIds);

    /**
     * 获取菜单
     * @return
     */
    List<zTreeNode> menuTreeList();
}
