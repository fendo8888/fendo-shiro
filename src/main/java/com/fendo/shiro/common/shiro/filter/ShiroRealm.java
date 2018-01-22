/**
 * projectName: fendo-plus-boot
 * fileName: ShiroRealm.java
 * packageName: com.fendo.shiro.common.shiro.filter
 * date: 2018-01-16 17:26
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.shiro.filter;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fendo.shiro.entity.RoleEntity;
import com.fendo.shiro.entity.UserEntity;
import com.fendo.shiro.entity.UserRoleEntity;
import com.fendo.shiro.service.MenuService;
import com.fendo.shiro.service.RoleService;
import com.fendo.shiro.service.UserRoleService;
import com.fendo.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ShiroRealm
 * @packageName: com.fendo.shiro.common.shiro.filter
 * @description: shiro 身份校验核心类
 * @data: 2018-01-16 17:26
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserEntity userInfo  = (UserEntity)principals.getPrimaryPrincipal();
        EntityWrapper<UserRoleEntity> parameter = new EntityWrapper<UserRoleEntity>();
        parameter.where("user_id",userInfo.getId());
        List<UserRoleEntity> userRoleEntityList = userRoleService.selectList(parameter);
        for(UserRoleEntity userRoleEntity : userRoleEntityList){
            RoleEntity roleEntity = roleService.selectById(userRoleEntity.getRoleId());
            authorizationInfo.addRole(roleEntity.getName());
        }
        return authorizationInfo;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo +"  + authcToken.toString());
        System.out.println("###【开始认证[SessionId]】"+ SecurityUtils.getSubject().getSession().getId());
        System.out.println(authcToken.getPrincipal());
        //获取用户的输入的账号.
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        EntityWrapper<UserEntity> userParameter = new EntityWrapper<UserEntity>();
        userParameter.where("name = {0}",username);
        UserEntity userInfo = userService.selectOne(userParameter);
        System.out.println("----->>userInfo=" + userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

}
