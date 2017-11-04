package com.walker.restfulapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.walker.restfulapi.common.redis.RedisService;
import com.walker.restfulapi.entity.User;
import com.walker.restfulapi.mapper.UserMapper;
import com.walker.restfulapi.util.PageData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;

/**
 * 说明：demo数据接口
 * 创建人：walker
 * 修改时间：2017-10-23
 */
@Service
public class UserService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String REDIS_KEY = "BACKSTAGE_MANAGE_USER_ALL";//最佳实践，项目名_模块名_业务名
    private static final Integer REDIS_TIME = 60 * 60 * 24 * 30 * 3;

    @Autowired
    private RedisService redisService;

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

        try {
            //先从缓存中命中，如果命中的话返回，没有命中，程序继续执行
            String cacheData= this.redisService.get(REDIS_KEY);
            if(StringUtils.isNotEmpty(cacheData)){
                //命中
                return MAPPER.readValue(cacheData,PageData.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PageData pd=userMapper.selectDemoByUsername(username);

        //不影响正常逻辑的情况下
        try {
            //将结果集写入到缓存中
            this.redisService.set(REDIS_KEY,MAPPER.writeValueAsString(pd),REDIS_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pd;
    }

    public User selectAll(){

        PageHelper.startPage(2,2);

        return userMapper.selectAll();
    }

}
