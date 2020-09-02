package com.wang.dao;

import com.wang.pojo.User;

import java.util.List;

public interface UserMapper {

    //根据ID查询用户
    User getUserById(int id);

}
