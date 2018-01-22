/**
 * projectName: fendo-plus-boot
 * fileName: IdGen.java
 * packageName: com.fendo.shiro.common.utils
 * date: 2018-01-20 23:04
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.utils;

import java.util.UUID;

/**
 * @version: V1.0
 * @author: fendo
 * @className: IdGen
 * @packageName: com.fendo.shiro.common.utils
 * @description: ID生成器
 * @data: 2018-01-20 23:04
 **/
public class IdGen {

    /**
     * 生成32位编码
     * @return string
     */
    public static String getUUID(){
        String uuid =  UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}
