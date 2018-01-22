/**
 * projectName: fendo-plus-boot
 * fileName: UserUtils.java
 * packageName: com.fendo.shiro.common.shiro
 * date: 2018-01-17 16:31
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.shiro;

import com.fendo.shiro.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import static at.pollux.thymeleaf.shiro.dialect.ShiroFacade.isGuest;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserUtils
 * @packageName: com.fendo.shiro.common.shiro
 * @description: 用户工具类
 * @data: 2018-01-17 16:31
 **/
public class UserUtils {

    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     *  获取当前用户
     * @return
     */
    public static UserEntity getUser() {
        if (isGuest()) {
            return null;
        } else {
            return (UserEntity) getSubject().getPrincipals().getPrimaryPrincipal();
        }
    }


}
