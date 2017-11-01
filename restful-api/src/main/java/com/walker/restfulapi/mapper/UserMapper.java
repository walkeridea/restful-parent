package com.walker.restfulapi.mapper;

import com.walker.restfulapi.entity.User;
import com.walker.restfulapi.util.PageData;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：mapper类
 * 创建人：walker
 * 修改时间：2017-10-23
 */
@Repository
public interface UserMapper {

    @Insert("insert into sys_user(username,password,age,last_login,remark) values(#{username},#{password},#{age},#{lastLogin},#{remark}) ")
    void insetDemo(User demo);

    @Update("update sys_user set password=#{password},age=#{age},remark=#{remark} where username=#{username}")
    void updateDemo(User demo);

    @Delete("delete from sys_user where username=#{username}")
    void deleteDemo(String username);

    @Select("select u.id userId,u.username,u.password,u.age,u.last_login lastLogin,u.remark,b.id roleId,b.role_name roleName,b.rights,b.parent_id parentId,b.add_qx addQx,b.del_qx delQx,b.edit_qx editQx,find_qx findQx from sys_user u left join sys_role b on u.role_id=b.id where u.username=#{username}")
    PageData selectDemoByUsername(String username);

    @Select("select id,username,password,age,last_login,remark,role_id from sys_user")
    @Results(
            {
                    @Result(id = true,column = "id",property = "id"),
                    @Result(column = "id",property = "buttonList",many = @Many(select = "com.walker.restfulapi.mapper.ButtonMapper.selectAllByDemoId"))

            }
    )
    User selectAll();




}
