package com.thinrain.springbootdemo.controller;

import com.thinrain.springbootdemo.model.Article;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Article hello(String name) {
        Article article = new Article(1,"liyaocool","测试标题","测试的内容.", new Date(), new Date());
        article.setAuthor(name);
        return article;
    }
}