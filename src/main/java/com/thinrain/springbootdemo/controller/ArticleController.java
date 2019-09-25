package com.thinrain.springbootdemo.controller;

import com.thinrain.springbootdemo.model.AjaxResponse;
import com.thinrain.springbootdemo.model.Article;
import com.thinrain.springbootdemo.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        //模拟数据
        List<Reader> readers = new ArrayList<>();
        Reader reader1 = new Reader(1,"zhangsan",19);
        Reader reader2 = new Reader(2,"lisi",29);
        readers.add(reader1);
        readers.add(reader2);
        Article article = Article.builder().id(id).author("小虾米").title("笑傲江湖").content("令狐冲的独孤九剑").readers(readers).build();
        return AjaxResponse.sucess(article);
    }
}