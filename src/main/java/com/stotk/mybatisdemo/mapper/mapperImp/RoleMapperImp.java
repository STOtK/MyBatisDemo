package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.model.SysRole;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
public interface RoleMapperImp {

    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")})

    @Select({"select id, role_name roleName, enabled,create_by createBy,create_time createTime from sys_role where id = #{id}"})
    SysRole selectById(Long id);

    @ResultMap("roleResultMap")
    @Select({"select * from sys_role"})
    List<SysRole> selectById2();
}
