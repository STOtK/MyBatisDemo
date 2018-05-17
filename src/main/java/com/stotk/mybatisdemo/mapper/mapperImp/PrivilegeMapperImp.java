package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.mapper.provider.PrivilegeProvider;
import com.stotk.mybatisdemo.model.SysPrivilege;
import org.apache.ibatis.annotations.SelectProvider;

/**
 *
 */
public interface PrivilegeMapperImp {

    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(long id);

}
