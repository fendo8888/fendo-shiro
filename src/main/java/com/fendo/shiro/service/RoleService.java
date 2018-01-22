/**
 * projectName: fendo-plus-boot
 * fileName: RoleService.java
 * packageName: com.fendo.shiro.service
 * date: 2018-01-15 20:45
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.service;

import com.baomidou.mybatisplus.service.IService;
import com.fendo.shiro.entity.RoleEntity;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: RoleService
 * @packageName: com.fendo.shiro.service
 * @description: 角色Service
 * @data: 2018-01-15 20:45
 **/
public interface RoleService extends IService<RoleEntity> {

    /**
     * 根据用户ID获取角色
     * @param userid
     * @return
     */
    List<RoleEntity> selectByUserId(String userid);
}
