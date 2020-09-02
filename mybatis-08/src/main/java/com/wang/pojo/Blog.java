package com.wang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private String id;
    private String title;
    private String author;
    //日期用util包中的
    //属性名和字段名不一致
    private Date createTime;
    private int views;
}
