package com.wang.dao;

import com.wang.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有的学生信息,以及对应的老师的信息
    List<Student> getStudentInfo();

    List<Student> getStudentInfo2();
}
