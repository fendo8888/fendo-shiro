/**
 * projectName: fendo-plus-boot
 * fileName: MenuController.java
 * packageName: com.fendo.shiro.controller
 * date: 2018-01-15 20:38
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fendo.shiro.common.node.TreeViewNode;
import com.fendo.shiro.common.node.zTreeNode;
import com.fendo.shiro.common.shiro.UserUtils;
import com.fendo.shiro.common.utils.PaginationResult;
import com.fendo.shiro.common.web.BaseController;
import com.fendo.shiro.entity.MenuEntity;
import com.fendo.shiro.entity.UserEntity;
import com.fendo.shiro.service.MenuService;
import com.fendo.shiro.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MenuController
 * @packageName: com.fendo.shiro.controller
 * @description: 菜单Controller
 * @data: 2018-01-15 20:38
 **/
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("menu")
    public String menuList(Model model){
        return "menuList";
    }

    @RequestMapping("menutree")
    public String menuListTree(Model model){
        return "menuListTree";
    }

    @RequestMapping("menutreeview")
    public String menuListTreeView(Model model){
        return "menuListTreeView";
    }

    @RequestMapping("menulist")
    @ResponseBody
    public PaginationResult menuList(String offset, String limit, String name,String sort,String sortOrder){
        UserEntity userEntity = UserUtils.getUser();
        if(!StringUtils.isNotBlank(offset) & !StringUtils.isNotBlank(limit)){
            offset = "1";
            limit = "5";
        }
        if(StringUtils.isEmpty(sort)){
            sort = "id";
        }
        boolean falg = true;
        if("desc".equals(sortOrder)){
            falg = false;
        }
        //分页 pageNumber--》页数    pageSize--》每页显示数据的条数
        int page_Num = Integer.parseInt(offset);
        int page_Size = Integer.parseInt(limit);
        Page<MenuEntity> page = new Page<MenuEntity>(page_Num, page_Size);
        //Page<MenuEntity> pageList = menuService.selectPage(page);

        EntityWrapper ew = new EntityWrapper();
        ew.setEntity(new MenuEntity());

        ew.like("name",name, SqlLike.DEFAULT).orderBy(sort,falg);
            //获取page对象;
        Page<MenuEntity> pageList = menuService.selectPage(page,ew);

        return new PaginationResult(pageList.getTotal(), pageList.getRecords());
    }

    @RequestMapping("menuaddindex")
    public String menuAddIndex(){
        return "menuAdd";
    }

    @RequestMapping("menuadd")
    public String menuAdd(MenuEntity menuEntity){
        //menuEntity.setId(IdGen.getUUID());
        menuService.insert(menuEntity);
        return "redirect:/menu/menu";
    }

    @RequestMapping("menulisttree")
    @ResponseBody
    public PaginationResult menuListTree(String offset, String limit, String name,String sort,String sortOrder){
        UserEntity userEntity = UserUtils.getUser();
        if(!StringUtils.isNotBlank(offset) & !StringUtils.isNotBlank(limit)){
            offset = "1";
            limit = "5";
        }
        if(StringUtils.isEmpty(sort)){
            sort = "id";
        }
        boolean falg = true;
        if("desc".equals(sortOrder)){
            falg = false;
        }
        //分页 pageNumber--》页数    pageSize--》每页显示数据的条数
        int page_Num = Integer.parseInt(offset);
        int page_Size = Integer.parseInt(limit);
        Page<MenuEntity> page = new Page<MenuEntity>(page_Num, page_Size);
        //Page<MenuEntity> pageList = menuService.selectPage(page);

        EntityWrapper ew = new EntityWrapper();
        ew.setEntity(new MenuEntity());

        ew.like("name",name, SqlLike.DEFAULT).orderBy(sort,falg);
        //获取page对象;
        Page<MenuEntity> pageList = menuService.selectPage(page,ew);

        return new PaginationResult(pageList.getTotal(), pageList.getRecords());
    }


    @RequestMapping("menutreeviewlist")
    @ResponseBody
    public String menuListTreeViewList(Model model){
        TreeViewNode treeViewNode = menuService.selectTreeViewNodeByRoleId(null);
        String string = JSON.toJSONString(treeViewNode);
        string = string.replaceAll("\"nodes\"\\:\\[\\],","");
        return string;
    }

    @RequestMapping("menuZtreeList")
    @ResponseBody
    public List<zTreeNode> menuZtreeList(Model model){
        List<zTreeNode> zTreeNodeList = menuService.menuTreeList();
        return zTreeNodeList;
    }
}
