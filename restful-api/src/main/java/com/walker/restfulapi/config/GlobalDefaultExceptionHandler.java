package com.walker.restfulapi.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * 说明：
 * 创建人：walker
 * 修改时间：2017-11-01
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e){
//        ModelAndView mv=new ModelAndView("/error");
//        mv.addObject("ex",e.getMessage().replaceAll("\n","<br/>"));
        return e.getMessage();
    }

}
