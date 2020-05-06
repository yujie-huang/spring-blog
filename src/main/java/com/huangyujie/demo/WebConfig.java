package com.huangyujie.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//映射图片保存地址
        registry.addResourceHandler("/uploadImges/**").addResourceLocations(" file:F:/spring/workspace-spring-tool-suite-4-4.5.1.RELEASE/sp3/src/main/resources/static/uploadImges/");
    }
    
    


}