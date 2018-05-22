package com.stotk.mybatisdemo.Imp;

import com.stotk.mybatisdemo.dao.UserEntityMapper;
import com.stotk.mybatisdemo.generator.model.UserEntity;
import com.stotk.mybatisdemo.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 *
 */
public class selectAllGenerator extends BaseMapper {

    private static SqlSession sqlSession = getSqlSession();

    @Test
    public void selectAllByGen() {
        try {
            UserEntityMapper mapper = sqlSession.getMapper(UserEntityMapper.class);
            List<UserEntity> user = mapper.selectAll();
            for (UserEntity item : user) {
                System.out.println(item.getId() + " " + item.getUserName() + " " + item.getUserPassword() + " " + item.getUserEmail() + " " + item.getUserInfo() + " " + item.getHeadImg() + " " + item.getCreateTime());
            }
            Assert.assertNotNull(user);
            Assert.assertTrue(user.size() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
