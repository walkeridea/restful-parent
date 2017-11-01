package com.walker.restfulapi.mapper;

import com.walker.restfulapi.entity.Button;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：
 * 创建人：walker
 * 修改时间：2017-10-23
 */
@Repository
public interface ButtonMapper {

    @Select("select id,name,auth_name,remark from sys_button where user_id=#{demoId}")
    List<Button> selectAllByDemoId(Long demoId);

}
