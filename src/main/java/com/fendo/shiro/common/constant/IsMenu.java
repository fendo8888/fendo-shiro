/**
 * projectName: fendo-plus-boot
 * fileName: IsMenu.java
 * packageName: com.fendo.shiro.common.constant
 * date: 2018-01-17 19:28
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.constant;

/**
 * @version: V1.0
 * @author: fendo
 * @className: IsMenu
 * @packageName: com.fendo.shiro.common.constant
 * @description: 是否是菜单的枚举
 * @data: 2018-01-17 19:28
 **/
public enum IsMenu {

    YES("1", "是"), //是菜单
    NO("0", "不是");//不是菜单的是按钮

    String code;
    String message;

    IsMenu(String code, String message) {
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
                if (s.getCode().equals(status)) {
                    return s.getMessage();
                }
            }
            return "";
        }

    }

}
