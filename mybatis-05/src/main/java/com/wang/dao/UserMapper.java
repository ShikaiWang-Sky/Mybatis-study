package com.wang.dao;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数,参数前面必须加上@Param("参数名")注解,SQL中取的参数是Param中的!(写在xml中的SQL也一样,只是不用指定ParamType了)
    @Select("select * from user where id = #{id} and name = #{name}")
    User getUserById(@Param("id") int id, @Param("name") String name);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{pwd})")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
