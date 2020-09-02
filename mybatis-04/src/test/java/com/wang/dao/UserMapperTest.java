package com.wang.dao;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapper.class);

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        //System.out.println(user);
        logger.info("id为1的用户的信息为: " + user);

        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        //日志的级别,info相当于sout
        logger.info("info:进入了testLog4j");
        logger.debug("info:进入了testLog4j");
        logger.error("info:进入了testLog4j");
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> userByLimit = mapper.getUserByLimit(map);

        for (User user : userByLimit) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void testGetUserByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 2);

        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.wang.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
