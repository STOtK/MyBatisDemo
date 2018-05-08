package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.mapper.mapperImp.UserMapperImp;
import com.stotk.mybatisdemo.model.SysRole;
import com.stotk.mybatisdemo.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class UserMapper extends BaseMapper {

    private static SqlSession sqlSession = getSqlSession();

    @Test
    public void testSelectById() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = userMapper.selectById(1);
            if (sysUser != null) {
                Assert.assertNotNull(sysUser);
            }
            Assert.assertEquals("admin", sysUser.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            List<SysUser> sysUserList = userMapper.selectAll();
            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectRolesByUserId() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            List<SysRole> sysUserList = userMapper.selectRolesByUserId(1001L);
            Assert.assertNotNull(sysUserList);
            Assert.assertTrue(sysUserList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    public void insertUser() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("admin_1");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("admin_1 infomation");
            sysUser.setUserEmail("admin1@mybatis.tk");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());
            int result = userMapper.insertUser(sysUser);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(sysUser.getId());
        } finally {
            //回滚数据插入，不提交事务，同时没有commit()操作，数据是不会在数据库中增加的
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void insertUserIndex() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("admin_1");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("admin_1 infomation");
            sysUser.setUserEmail("admin1@mybatis.tk");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());
            int result = userMapper.insertUserIndex(sysUser);
            Assert.assertEquals(1, result);
            Assert.assertNotNull(sysUser.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("admin", user.getUserName());
            user.setUserName("admin_test");
            user.setUserEmail("admintest@mybatis.tk");
            int result = userMapper.updateById(user);
            Assert.assertEquals(1, result);
            user = userMapper.selectById(1L);
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
