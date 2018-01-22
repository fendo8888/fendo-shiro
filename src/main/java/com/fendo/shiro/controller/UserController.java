/**
 * projectName: fendo-plus-boot
 * fileName: UserController.java
 * packageName: com.fendo.shiro.controller
 * date: 2018-01-15 15:52
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.controller;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fendo.shiro.common.utils.PaginationResult;
import com.fendo.shiro.common.web.BaseController;
import com.fendo.shiro.entity.UserEntity;
import com.fendo.shiro.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserController
 * @packageName: com.fendo.shiro.controller
 * @description: 用户Controller
 * @data: 2018-01-15 15:52
 **/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 用户页跳转
     * @return
     */
    @RequestMapping("/userIndex")
    public String userIndex(){
        return "userList";
    }

    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public PaginationResult userList(String offset, String limit, String name,String sort,String sortOrder){
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
        Page<UserEntity> page = new Page<UserEntity>(page_Num, page_Size);
        EntityWrapper ew = new EntityWrapper();
        ew.setEntity(new UserEntity());

        ew.like("name",name, SqlLike.DEFAULT).orderBy(sort,falg);
        //获取page对象;
        Page<UserEntity> pageList = userService.selectPage(page,ew);
        return new PaginationResult(pageList.getTotal(), pageList.getRecords());
    }


}
