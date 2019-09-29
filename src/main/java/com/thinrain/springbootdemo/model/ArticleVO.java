package com.thinrain.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data //自动装配setter,getter
@AllArgsConstructor //自动初始化声明的成员变量
@NoArgsConstructor //无参构造
@Builder //实例化时候可以快捷使用builder().id().author....build()
public class ArticleVO {

    private Integer id;
    private String author;
    private String title;
    private String content;

    //已经在全局application.yml配置全局json时间格式化,可注释,单元测试时要开启
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonInclude(JsonInclude.Include.NON_NULL) //选用 非空的
    private Date createTime;

    //已经在全局application.yml配置全局json时间格式化,可注释,单元测试时要开启
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonInclude(JsonInclude.Include.NON_NULL) //选用 非空的
    private Date updateTime;

    @JsonInclude(JsonInclude.Include.NON_NULL) //选用 非空的
    private List<Reader> readers;
}
