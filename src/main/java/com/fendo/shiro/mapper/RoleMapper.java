/**
 * projectName: fendo-plus-boot
 * fileName: RoleMapper.java
 * packageName: com.fendo.shiro.mapper
 * date: 2018-01-15 20:35
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fendo.shiro.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: RoleMapper
 * @packageName: com.fendo.shiro.mapper
 * @description: 角色表
 * @data: 2018-01-15 20:35
 **/
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 根据用户ID获取角色
     * @param userid
     * @return
     */
    List<RoleEntity> selectByUserId(@Param("userid") String userid);
}
