package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.model.SysUser;

import java.util.List;

/**
 *
 */
public interface UserMapper {
    /**
     * 返回用户名为id的用户
     *
     * @param id
     * @return
     */
    SysUser selectById(long id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<SysUser> selectAll();
}
