package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.model.Country;
import com.stotk.mybatisdemo.model.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 *
 */
public class BaseMapper {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<SysUser> countries = sqlSession.selectList("com.stotk.mybatisdemo.mapper.UserMapper.selectAll");
            printCountryList(countries);
        } finally {
            sqlSession.close();
        }
    }

    private void printCountryList(List<SysUser> countryList) {
        for (SysUser item : countryList) {
            System.out.printf("%4d %4s %4s\n", item.getId(), item.getUserName(), item.getUserEmail());
        }
    }
}
