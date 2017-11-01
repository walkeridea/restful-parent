package com.walker.restfulapi.mapper;

import com.walker.restfulapi.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    @Select("select id,role_name,rights,parent_id,add_qx,del_qx,find_qx,edit_qx from sys_role where id=#{roleId}")
    Role selectRole(Integer roleId);
}
