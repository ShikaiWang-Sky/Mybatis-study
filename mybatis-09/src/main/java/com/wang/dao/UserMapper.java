package com.wang.dao;

import com.wang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //根据id查询用户
    User queryUserById(@Param("id") int id);
}
