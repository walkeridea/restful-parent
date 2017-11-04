package com.walker.restfulapi.adapter;

import com.walker.restfulapi.interceptor.CharacterEncodeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 说明：适配器
 * 创建人：walker
 * 修改时间：2017-11-01
 */
@Configuration
public class RestfulWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CharacterEncodeInterceptor()).addPathPatterns("/unionpay/**");

        super.addInterceptors(registry);
    }
}
