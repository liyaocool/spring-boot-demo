package com.thinrain.springbootdemo.controller;

import com.thinrain.springbootdemo.model.AjaxResponse;
import com.thinrain.springbootdemo.model.ArticleVO;
import com.thinrain.springbootdemo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @PostMapping()
    public AjaxResponse addArticle(@RequestBody ArticleVO articleVO) {
        articleService.addArticle(articleVO);
        return AjaxResponse.sucess(articleVO);
    }

    @DeleteMapping("{id}")
    public AjaxResponse delArticleById(@PathVariable Integer id) {
        articleService.delArticle(id);
        log.info("delArticleById:" + id);
        return AjaxResponse.sucess();
    }

    @PutMapping("{id}")
    public AjaxResponse updateArticle(@PathVariable Integer id, @RequestBody ArticleVO articleVO) {
        articleVO.setId(id);
        articleService.updateArticle(articleVO);
        return AjaxResponse.sucess(articleVO);
    }

    @GetMapping("{id}")
    public AjaxResponse getArticleById(@PathVariable Integer id) {

        return AjaxResponse.sucess(articleService.getArticle(id));
    }

    @GetMapping()
    public AjaxResponse getAllArticles() {

        return AjaxResponse.sucess(articleService.getAllArticles());
    }
}