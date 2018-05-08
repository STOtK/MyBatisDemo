package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.model.SysRole;
import com.stotk.mybatisdemo.model.SysUser;

import java.util.List;

/**
 *
 */
public interface UserMapperImp {
    /**
     * 返回用户名为id的用户
     * 单表查询
     *
     * @param id
     * @return
     */
    SysUser selectById(long id);

    /**
     * 查询所有用户
     * 单表查询
     *
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户Id获取角色信息
     * 关联表查询
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(long userId);

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    int insertUser(SysUser sysUser);

    /**
     * 新增用户并返回自增主键
     *
     * @param sysUser
     * @return
     */
    int insertUserIndex(SysUser sysUser);

    /**
     * 使用selectKey返回主键的值
     *
     * @param sysUser
     * @return
     */
    int insertUserReturnKey(SysUser sysUser);

    /**
     * 根据主键更新
     *
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);
}
