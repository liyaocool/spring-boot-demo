package com.thinrain.springbootdemo.controller;

import com.thinrain.springbootdemo.model.AjaxResponse;
import com.thinrain.springbootdemo.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @PostMapping()
    public AjaxResponse addArticle(@RequestBody Article article) {
        log.info("addArticle:" + article);
        return AjaxResponse.sucess(article);
    }

    @DeleteMapping("{id}")
    public AjaxResponse delArticleById(@PathVariable Integer id) {
        log.info("delArticleById:" + id);
        return AjaxResponse.sucess();
    }

    @PutMapping()
    public AjaxResponse updateArticle(@RequestBody Article article) {
        log.info("updateArticle:" + article);
        return AjaxResponse.sucess(article);
    }

    @GetMapping("{id}")
    public AjaxResponse getArticleById(@PathVariable Integer id) {
        log.info("getArticleById:" + id);
        Article article = Article.builder().id(id).author("小虾米").title("笑傲江湖").content("令狐冲的独孤九剑").build();
        return AjaxResponse.sucess(article);
    }
}