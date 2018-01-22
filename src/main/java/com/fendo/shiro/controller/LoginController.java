/**
 * projectName: fendo-plus-boot
 * fileName: LoginController.java
 * packageName: com.fendo.shiro.controller
 * date: 2018-01-15 15:55
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.controller;

import com.fendo.shiro.common.web.BaseController;
import com.fendo.shiro.entity.UserEntity;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: LoginController
 * @packageName: com.fendo.shiro.controller
 * @description: 登陆Controller
 * @data: 2018-01-15 15:55
 **/
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map,@ModelAttribute UserEntity userEntity) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        logger.info("exception={}",exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountException -- > 账号不存在");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确");
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "验证码错误";
            } else {
                msg = " "+exception;
                logger.info("else -- >" + exception);
            }
        }
        //endregion
        //</editor-fold>
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

}
