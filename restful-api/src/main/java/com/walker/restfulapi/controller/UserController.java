package com.walker.restfulapi.controller;

import com.walker.restfulapi.common.result.JsonResult;
import com.walker.restfulapi.common.result.ResultCode;
import com.walker.restfulapi.entity.User;
import com.walker.restfulapi.service.UserService;
import com.walker.restfulapi.util.PageData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 说明：测试控制器
 * 创建人：walker
 * 修改时间：2017-10-23
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 增加用户信息
     * @param demo
     * @return
     */
    @RequestMapping(value = "/insert",method = {RequestMethod.POST},consumes = "application/json")
    public JsonResult insertDemo(User demo){

        demo.setAge(122);
        demo.setLastLogin(new Date());
        demo.setRemark("我的测试类");
        userService.insertDemo(demo);
        return new JsonResult(ResultCode.SUCCESS,"插入数据成功");
    }

    /**
     * 根据用户名更新数据
     * @param demo
     * @return
     */
    @RequestMapping(value = "update/{username}",method = {RequestMethod.POST},consumes = "application/json")
    public JsonResult updateDemo(User demo){
        userService.updateDemo(demo);
        return new JsonResult(ResultCode.SUCCESS,"更新"+demo.getUsername()+"数据成功");
    }

    /**
     * 根据用户名删除用户
     * @param username
     * @return
     */
    @RequestMapping(value = "delete/{username}",method = {RequestMethod.GET})
    public JsonResult deleteDemo(@PathVariable String username){
        userService.deleteDemo(username);
        return new JsonResult(ResultCode.SUCCESS,"删除数据成功");
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @RequestMapping(value = "select/{username}",method = {RequestMethod.GET})
    public JsonResult selectDemoByUsername(@PathVariable String username){
        PageData demo= userService.selectDemoByUsername(username);
        return new JsonResult(ResultCode.SUCCESS,"查询数据成功",demo);
    }

    /**
     * 获取所有数据
     * @return
     */
    @RequestMapping(value = "select/demos",method = {RequestMethod.GET})
    public JsonResult selectAll(){

        User demos= userService.selectAll();
        return new JsonResult(ResultCode.SUCCESS,"查询数据成功",demos);
    }



}
