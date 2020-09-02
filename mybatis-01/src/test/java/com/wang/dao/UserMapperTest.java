package com.wang.dao;

import com.wang.pojo.User;
import com.wang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        //第一步: 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            //第一步: 获取sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();

            //方式一: 执行SQL
            //面向接口编程,向getMapper传递一个对应的接口的class,用反射
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从得到的mapper对象中取出对应的方法,不用关心其实现
            List<User> userList = userMapper.getUserList();

            //方法二:
            //List<User> userList = sqlSession.selectList("com.wang.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }


    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改必须要提交事务!
    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "王麻子", "123456789");
        int num = mapper.addUser(user);
        if (num > 0) {
            System.out.println("插入成功!");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void TestUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(4, "赵六", "987654");
        int num = mapper.updateUser(user);
        if (num > 0) {
            System.out.println("修改成功!");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int num = mapper.deleteUser(4);
        if (num > 0) {
            System.out.println("删除成功!");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    //增删改必须要提交事务!
    @Test
    public void testAddUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", 4);
        map.put("userName", "王麻子");
        map.put("password", "123456789");
        int num = mapper.addUser2(map);
        if (num > 0) {
            System.out.println("插入成功!");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    //模糊查询
    @Test
    public void testGetUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserLike("%王%");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
