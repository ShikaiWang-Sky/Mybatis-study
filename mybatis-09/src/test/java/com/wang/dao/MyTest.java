package com.wang.dao;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void TestQueryUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("==============================");
        sqlSession.clearCache();
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

        sqlSession.close();
    }

}
