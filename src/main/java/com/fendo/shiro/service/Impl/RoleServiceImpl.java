/**
 * projectName: fendo-plus-boot
 * fileName: RoleServiceImpl.java
 * packageName: com.fendo.shiro.service.Impl
 * date: 2018-01-15 20:51
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fendo.shiro.entity.RoleEntity;
import com.fendo.shiro.mapper.RoleMapper;
import com.fendo.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: RoleServiceImpl
 * @packageName: com.fendo.shiro.service.Impl
 * @description:
 * @data: 2018-01-15 20:51
 **/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleEntity> selectByUserId(String userid) {
        return roleMapper.selectByUserId(userid);
    }
}
