package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.model.SysRole;
import org.apache.ibatis.annotations.*;

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

    /**
     * 不返回自增主键
     *
     * @param sysRole
     * @return
     */
    @Insert({"insert into sys_role (id,role_name,enabled,create_by,create_time) values(#{id}, #{roleName}, #{enabled}, #{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    int insertSysRole(SysRole sysRole);

    /**
     * 返回自增主键
     *
     * @param sysRole
     * @return
     */
    @Insert({"insert into sys_role (role_name,enabled,create_by,create_time) values(#{roleName}, #{enabled}, #{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSysRole2(SysRole sysRole);

    /**
     * 返回主键，但是该主键不是自增主键
     *
     * @param sysRole
     * @return
     */
    @Insert({"insert into sys_role (role_name,enabled,create_by,create_time) values(#{roleName}, #{enabled}, #{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT ID()", keyProperty = "id", resultType = Long.class, before = false)
    int insertSysRole3(SysRole sysRole);

    /**
     * update 和 delete 注解与select 相同
     */
}
