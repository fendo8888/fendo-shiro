/**
 * projectName: fendo-plus-boot
 * fileName: MybatisPlusConfig.java
 * packageName: com.fendo.mybatis.plus.config
 * date: 2018-01-12 23:13
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MybatisPlusConfig
 * @packageName: com.fendo.mybatis.plus.config
 * @description: Mybatis-plus配置类
 * @data: 2018-01-12 23:13
 **/
@Configuration
@MapperScan("com.fendo.shiro.mapper*")
public class MybatisPlusConfig {
    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
