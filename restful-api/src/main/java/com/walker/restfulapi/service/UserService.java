package com.walker.restfulapi.service;

import com.github.pagehelper.PageHelper;
import com.walker.restfulapi.entity.User;
import com.walker.restfulapi.mapper.UserMapper;
import com.walker.restfulapi.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：demo数据接口
 * 创建人：walker
 * 修改时间：2017-10-23
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void insertDemo(User demo){
        userMapper.insetDemo(demo);
    }

    @Transactional
    public void updateDemo(User demo){
        userMapper.updateDemo(demo);
    }

    @Transactional
    public void deleteDemo(String username){
        userMapper.deleteDemo(username);
    }

    public PageData selectDemoByUsername(String username){
        return userMapper.selectDemoByUsername(username);
    }

    public User selectAll(){

        PageHelper.startPage(2,2);

        return userMapper.selectAll();
    }

}
