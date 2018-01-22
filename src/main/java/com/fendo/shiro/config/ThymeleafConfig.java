/**
 * projectName: fendo-plus-boot
 * fileName: ThymeleafConfig.java
 * packageName: com.fendo.shiro.config
 * date: 2018-01-20 12:47
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.config;

import com.fendo.shiro.common.dialect.dict.DictDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ThymeleafConfig
 * @packageName: com.fendo.shiro.config
 * @description: thymeleaf 配置
 * @data: 2018-01-20 12:47
 **/
@Configuration
public class ThymeleafConfig {

    @Bean
    public DictDialect ditDialect(){
        return new DictDialect();
    }
}