package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.mapper.mapperImp.UserMapperImp;
import com.stotk.mybatisdemo.model.SysRole;
import com.stotk.mybatisdemo.model.SysUser;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void deleteById() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = userMapper.selectById(1L);
            Assert.assertNotNull(sysUser);
            Assert.assertEquals(1, userMapper.deleteById(1L));
            Assert.assertNull(userMapper.selectById(1L));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            //调用selectRolesByUserIdAndRoleEnabled方法查询用户的角色
            List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            //结果不为空
            Assert.assertNotNull(userList);
            //角色数量大于0个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    /**
     * <where></where> 标签更为合理
     */
    @Test
    public void selectUserByIf() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("admin");
            List<SysUser> sysUserList = userMapper.selectUserByIf(sysUser);
            Assert.assertTrue(sysUserList.size() > 0);
            sysUser = new SysUser();
            sysUser.setUserEmail("admin@mybatis.tk");
            sysUserList = userMapper.selectUserByIf(sysUser);
            Assert.assertTrue(sysUserList.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateByIdSelective() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = new SysUser();
            sysUser.setId(1L);
            sysUser.setUserName("test");
            int result = userMapper.updateByIdSelective(sysUser);
            Assert.assertEquals(1, result);
            sysUser = userMapper.selectById(1L);
            Assert.assertEquals("test", sysUser.getUserName());
            Assert.assertEquals("admin@mybatis.tk", sysUser.getUserEmail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //insert方法相同

    /**
     * 每次只有有一个非空属性值
     */
    @Test
    public void selectByIdOrUserName() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            SysUser sysUser = new SysUser();
            //sysUser.setId(0L);
            sysUser.setUserName("admin");
            sysUser.setUserEmail("admin@mybatis.tk");
            SysUser user = userMapper.selectByIdOrUserName(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * foreach() 实现批量查询
     */
    @Test
    public void selectByIdList() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            List<Long> list = new ArrayList<Long>();
            list.add(1L);
            list.add(1001L);
            List<SysUser> sysUserList = userMapper.selectByIdList(list);
            Assert.assertEquals(2, sysUserList.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertSysUserList() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            List<SysUser> userList = new ArrayList<SysUser>();
            for (int i = 0; i < 2; i++) {
                SysUser user = new SysUser();
                user.setUserName("test" + i);
                user.setUserPassword("123456");
                user.setUserEmail("test@mybatis.tk");
                userList.add(user);
            }
            int result = userMapper.insertSysUserList(userList);
            Assert.assertEquals(2, result);
            for (SysUser item : userList) {
                System.out.println(item.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void updateByMap() {
        try {
            UserMapperImp userMapper = sqlSession.getMapper(UserMapperImp.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1L);
            map.put("user_email", "test@mybatis.tk");
            map.put("user_password", "12345678");
            userMapper.updateByMap(map);
            SysUser user = userMapper.selectById(1L);
            Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}