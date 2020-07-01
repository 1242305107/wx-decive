package com.tckj.wx.application.config.mybatisPlus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WCH
 * @date 2020/6/24 10:09
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

}
