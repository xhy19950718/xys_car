package com.xys.car.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MySpringMVCConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
        // super.addInterceptors(registry);
        // registry.addInterceptor(commonInterceptor).addPathPatterns("/**").excludePathPatterns("/login",
        // "/register");

    }
    /*
     * @Override public void addInterceptors(InterceptorRegistry registry){
     * registry.addInterceptor(userConfig).add }
     */

}
