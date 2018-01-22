package com.fendo.shiro.common.constant;

/**
 * @version: V1.0
 * @author: fendo
 * @className: IsMenu
 * @packageName: com.fendo.shiro.common.constant
 * @description: 是否是显示枚举
 * @data: 2018-01-17 19:28
 **/
public enum IsShow {

    YES("1", "是"), //是菜单
    NO("0", "否");//不是菜单的是按钮

    String code;
    String message;

    IsShow(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (IsMenu s : IsMenu.values()) {
                if (status.equals(s.getCode())) {
                    return s.getMessage();
                }
            }
            return "";
        }

    }

}
