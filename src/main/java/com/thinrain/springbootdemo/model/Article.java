package com.thinrain.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data //自动装配setter,getter
@AllArgsConstructor //自动初始化声明的成员变量
public class Article {
    private int id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
}
