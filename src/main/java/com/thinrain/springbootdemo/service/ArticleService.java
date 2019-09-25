package com.thinrain.springbootdemo.service;

import com.thinrain.springbootdemo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleService {
    public String addArticle(Article article) {
        //DAO层
        log.info("已发表文章!" + article);
        return "已发表文章!";
    }

    public String delArticle(Integer id) {
        //DAO层
        log.info("已删除文章!" + id);
        return "已删除文章!";
    }
}
