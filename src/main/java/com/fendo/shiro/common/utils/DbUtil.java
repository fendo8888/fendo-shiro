/**
 * projectName: fendo-plus-boot
 * fileName: DbUtil.java
 * packageName: com.fendo.shiro.common.utils
 * date: 2018-01-21 11:26
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.utils;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fendo.shiro.entity.MenuEntity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DBUtil
 * @packageName: com.fendo.shiro.common.utils
 * @description: 数据库工具类
 * @data: 2018-01-21 11:26
 **/
public class DbUtil {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    //public String autoId(){
    //
    //}

    public String reflectTable(Object object){
        String tableName = null;
        // 此处要用反射将字段中的注解解析出来
        Class<Object> clz = Object.class;
        // 判断类上是否有次注解
        boolean clzHasAnno = clz.isAnnotationPresent(TableName.class);
        if (clzHasAnno) {
            // 获取类上的注解
            TableName annotation = clz.getAnnotation(TableName.class);
            // 输出注解上的属性
            tableName = annotation.value();
            System.out.println(clz.getName() + "--------" + tableName);
        }
        return tableName;
    }

    public static void main(String[] args) {
        // 此处要用反射将字段中的注解解析出来
        Class<MenuEntity> clz = MenuEntity.class;
        // 判断类上是否有次注解
        boolean clzHasAnno = clz.isAnnotationPresent(TableName.class);
        if (clzHasAnno) {
            // 获取类上的注解
            TableName annotation = clz.getAnnotation(TableName.class);
            // 输出注解上的属性
            String TableName = annotation.value();
            System.out.println(clz.getName() + "--------" + TableName);
        }
    }
}
