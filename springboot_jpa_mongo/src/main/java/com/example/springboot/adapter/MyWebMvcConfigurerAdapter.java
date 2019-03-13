package com.example.springboot.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    /**
     * 配置静态访问资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // addResourceHandler -> 外部暴露文件路劲
        // addResourceLocations -> 内部映射路径
        registry.addResourceHandler("/img/**").addResourceLocations("file:E:/my/");
        super.addResourceHandlers(registry);
    }
}

