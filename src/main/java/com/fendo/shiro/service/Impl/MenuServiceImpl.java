/**
 * projectName: fendo-plus-boot
 * fileName: MenuServiceImpl.java
 * packageName: com.fendo.shiro.service.Impl
 * date: 2018-01-15 20:49
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.service.Impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fendo.shiro.common.node.TreeViewNode;
import com.fendo.shiro.common.node.zTreeNode;
import com.fendo.shiro.entity.MenuEntity;
import com.fendo.shiro.mapper.MenuMapper;
import com.fendo.shiro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MenuServiceImpl
 * @packageName: com.fendo.shiro.service.Impl
 * @description:
 * @data: 2018-01-15 20:49
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuEntity> selectMenusByRoleIds(List<String> roleIds) {
        return menuMapper.selectMenusByRoleIds(roleIds);
    }

    @Override
    public TreeViewNode selectTreeViewNodeByRoleId(List<String> roleIds) {
        TreeViewNode treeViewNode = createTree("2","2");
        return treeViewNode;
    }

    @Override
    public List<zTreeNode> menuTreeList() {
        return menuMapper.menuTreeList();
    }

    /**
     *
     * @param id
     * @param historyId
     * @return
     */
    public  TreeViewNode createTree(String id,String historyId) {
        // 第一次应该获取的根节点
        TreeViewNode node = getTreeNode(id);
        // 获取根节点下的所有子节点
        List<TreeViewNode> childTreeNodes = queryChildTreeNode(String.valueOf(node.getId()));
        // 判断是否为叶子节点
        if (childTreeNodes.isEmpty()) {
            node.setLeaf(true);
            node.setSelectable(true);//只有叶子节点才可以被选中
            node.getState().setExpanded(true);
            // 如果叶子节点的id等于之前选中的historyId，那么该叶子节点默认选中
            if(historyId.equals(node.getId())){
                node.getState().setSelected(true);
            }
        } else {
            //不是叶子节点，递归查询下一层子节点
            for (TreeViewNode child : childTreeNodes) {
                TreeViewNode n = createTree(String.valueOf(child.getId()),historyId); // 递归
                node.getNodes().add(n);
            }
        }

        return node;
    }

    private  TreeViewNode getTreeNode(String id) {
        TreeViewNode node = new TreeViewNode();
        //从数据库中查询节点
        EntityWrapper<MenuEntity> parame = new EntityWrapper<MenuEntity>();
        parame.where("id = {0}",id);
        MenuEntity menuEntity = menuMapper.selectById(id);
        node.setText(menuEntity.getName());
        node.setId(""+menuEntity.getId());
        node.setLevel(menuEntity.getLevels());
        node.setPid(menuEntity.getParentId());
        return node;
    }

    private  List<TreeViewNode> queryChildTreeNode(String pId) {
        //从数据库中查询pId下的子节点数据
        Wrapper<MenuEntity> wrapper = new EntityWrapper<MenuEntity>();
        wrapper = wrapper.eq("parent_id",pId);
        List<MenuEntity> dicts = menuMapper.selectList(wrapper);
        List<TreeViewNode> childTreeNodes = new ArrayList<TreeViewNode>();
        for (MenuEntity object : dicts) {
            TreeViewNode node = new TreeViewNode();
            node.setText(object.getName());
            node.setId(""+object.getId());
            node.setLevel(object.getLevels());
            node.setPid(object.getParentId());
            childTreeNodes.add(node);
        }
        return childTreeNodes;
    }
}
