package com.stotk.mybatisdemo.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 *
 */
public class PrivilegeProvider {

    /**
     * 这边要注意，查出的列名，必须与程序中定义的名称必须完全一样
     *
     * @param id
     * @return
     */
    public String selectById(long id) {
        return "select id,privilege_name privilegeName,privilege_url privilegeUrl from sys_privilege where id=#{id}";
    }
}