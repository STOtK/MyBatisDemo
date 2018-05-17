package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.model.SysRole;
import com.stotk.mybatisdemo.model.SysUser;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过主键删除
     *
     * @param id
     * @return
     */
    int deleteById(long id);

    /**
     * 根据用户id 和角色的enabled 状态获取用户的角色
     *
     * @param id
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("id") Long id, @Param("enabled") Integer enabled);

    /**
     * 根据动态条件查询用户信息
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectUserByIf(SysUser sysUser);

    /**
     * 根据动态条件更新用户数据
     *
     * @param sysUser
     * @return
     */
    int updateByIdSelective(SysUser sysUser);
}
