package com.tckj.wx.application.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author WCH
 * @date 2020/6/23 17:07
 */
@Configuration
public class WebAdapterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有D:/files/myTest/ 访问都映射到/myTest/** 路径下
        registry.addResourceHandler("/image/**").addResourceLocations("file:/data/gfc-project/file/image/");
        super.addResourceHandlers(registry);
    }
}