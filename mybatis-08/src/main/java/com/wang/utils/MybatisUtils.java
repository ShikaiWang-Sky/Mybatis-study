package com.wang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --> sqlSession
public class MybatisUtils {

    //sqlSessionFactory要在后面的静态方法中生产sqlSession,这里要提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis第一步: 获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例
    //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法

    //使用静态方法,方便直接调用,生产一个sqlSession
    //openSession参数设置为true ==> 默认开启事务
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
