package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.mapper.mapperImp.RoleMapperImp;
import com.stotk.mybatisdemo.model.SysRole;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 *
 */
public class RoleMapper extends BaseMapper {

    private static SqlSession sqlSession = getSqlSession();

    @Test
    public void selectById() {
        try {
            RoleMapperImp roleMapper = sqlSession.getMapper(RoleMapperImp.class);
            SysRole role = roleMapper.selectById(1L);
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.getRoleName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectById2() {
        try {
            RoleMapperImp roleMapper = sqlSession.getMapper(RoleMapperImp.class);
            List<SysRole> role = roleMapper.selectById2();
            Assert.assertNotNull(role);
            Assert.assertEquals("管理员", role.get(0).getRoleName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
