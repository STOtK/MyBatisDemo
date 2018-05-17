package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.mapper.mapperImp.RoleMapperImp;
import com.stotk.mybatisdemo.model.SysRole;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
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

    @Test
    public void insertSysRole() {
        try {
            RoleMapperImp roleMapper = sqlSession.getMapper(RoleMapperImp.class);
            SysRole sysRole = new SysRole();
            sysRole.setId(3);
            sysRole.setRoleName("超级会员");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1);
            sysRole.setCreateTime(new Date());
            int role = roleMapper.insertSysRole(sysRole);
            Assert.assertNotNull(role);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertSysRole2() {
        try {
            RoleMapperImp roleMapper = sqlSession.getMapper(RoleMapperImp.class);
            SysRole sysRole = new SysRole();
            sysRole.setRoleName("超级会员");
            sysRole.setEnabled(1);
            sysRole.setCreateBy(1);
            sysRole.setCreateTime(new Date());
            //role返回的是影响的行数，并不是主键的值
            int role = roleMapper.insertSysRole2(sysRole);
            Assert.assertNotNull(role);
            System.out.println("主键：" + sysRole.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
