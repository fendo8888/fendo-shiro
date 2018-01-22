/**
 * projectName: fendo-plus-boot
 * fileName: Controller.java
 * packageName: com.fendo.shiro.controller
 * date: 2018-01-15 16:09
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.controller;

import com.alibaba.fastjson.JSON;
import com.fendo.shiro.common.shiro.UserUtils;
import com.fendo.shiro.common.web.BaseController;
import com.fendo.shiro.entity.MenuEntity;
import com.fendo.shiro.entity.RoleEntity;
import com.fendo.shiro.entity.UserEntity;
import com.fendo.shiro.service.MenuService;
import com.fendo.shiro.service.RoleService;
import com.fendo.shiro.service.UserRoleService;
import com.fendo.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: Controller
 * @packageName: com.fendo.shiro.controller
 * @description: 测试Controller
 * @data: 2018-01-15 16:09
 **/
@Controller
public class IndexController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping({"/","/index"})
    public String index(Model model){
        //获取菜单列表
        UserEntity userEntity = UserUtils.getUser();
        if(userEntity == null){
                UserUtils.getSubject().logout();
        }
        //获取角色
        List<RoleEntity> roleEntityList = roleService.selectByUserId(""+userEntity.getId());
        if(roleEntityList ==null && roleEntityList.size()<0){
            return null;
        }
        userEntity.setRoleEntityList(roleEntityList);
        //获取菜单
        List<String> roleIds = new ArrayList<String>();
        for (int i = 0; i < roleEntityList.size(); i++) {
            roleIds.add(""+roleEntityList.get(i).getId());
        }
        List<MenuEntity> menuEntityList = menuService.selectMenusByRoleIds(roleIds);
        if(menuEntityList ==null && menuEntityList .size()<0){
            return null;
        }
        List<MenuEntity> titles = MenuEntity.buildMenu(menuEntityList);
        System.out.println(JSON.toJSONString(titles));
        userEntity.setMenuEntityList(titles);
        model.addAttribute("menuList",titles);
        return"index";
    }

    @RequestMapping({"/welcome"})
    public String welcome(){
        return"welcome";
    }
}
