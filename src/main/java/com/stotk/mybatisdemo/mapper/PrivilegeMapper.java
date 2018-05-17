package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.mapper.mapperImp.PrivilegeMapperImp;
import com.stotk.mybatisdemo.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class PrivilegeMapper extends BaseMapper {

    private static SqlSession sqlSession = getSqlSession();

    @Test
    public void selectById() {
        try {
            //获取PrivilegeMapper 接口
            PrivilegeMapperImp privilegeMapper = sqlSession.getMapper(PrivilegeMapperImp.class);
            //调用selectById方法，查询id=1的权限
            SysPrivilege privilege = privilegeMapper.selectById(1L);
            //privilege 不为空
            Assert.assertNotNull(privilege);
            //privilegeName ＝ 用户管理
            Assert.assertEquals("用户管理", privilege.getPrivilegeName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
