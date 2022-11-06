package com.hongfu.config;

import com.hongfu.interceptor.MyRestfulInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/public/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyRestfulInterceptor())
                //.addPathPatterns("/**")//  /** 拦截所有路径
                //设置不拦截的路径，"/asserts/**","/webjars/**" 静态资源也不能拦截，
                //SpringBoot1.x好像不会拦截静态资源，但是SpringBoot2.x会拦截静态资源，所以需要排除掉
                .excludePathPatterns("/*","/index.html","/user/login","/asserts/**","/webjars/**");
    }
}
