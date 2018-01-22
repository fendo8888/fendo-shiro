/**
 * projectName: fendo-plus-boot
 * fileName: UserRoleServiceImpl.java
 * packageName: com.fendo.shiro.service.Impl
 * date: 2018-01-15 20:52
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fendo.shiro.entity.UserRoleEntity;
import com.fendo.shiro.mapper.UserRoleMapper;
import com.fendo.shiro.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserRoleServiceImpl
 * @packageName: com.fendo.shiro.service.Impl
 * @description:
 * @data: 2018-01-15 20:52
 **/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {

}
