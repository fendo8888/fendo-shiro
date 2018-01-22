/**
 * projectName: fendo-plus-boot
 * fileName: UserServiceImpl.java
 * packageName: com.fendo.shiro.service.Impl
 * date: 2018-01-15 20:53
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fendo.shiro.entity.UserEntity;
import com.fendo.shiro.mapper.UserMapper;
import com.fendo.shiro.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserServiceImpl
 * @packageName: com.fendo.shiro.service.Impl
 * @description:
 * @data: 2018-01-15 20:53
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
}
