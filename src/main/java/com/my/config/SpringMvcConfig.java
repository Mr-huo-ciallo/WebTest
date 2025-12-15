package com.my.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.context.annotation.Bean;

@Configuration
// 等同于<context:component-scan base-package="com.my.controller"/>
@ComponentScan("com.my.controller")
// 等同于<mvc:annotation-driven/>，还不完全相同
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源处理，将/css/**映射到webapp/css目录
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    // 配置JSP视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 设置视图前缀，指向webapp目录
        resolver.setPrefix("/");
        // 设置视图后缀
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
