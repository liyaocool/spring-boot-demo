package com.thinrain.springbootdemo.controller;

import com.thinrain.springbootdemo.model.AjaxResponse;
import com.thinrain.springbootdemo.model.ArticleVO;
import com.thinrain.springbootdemo.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
        return AjaxResponse.sucess();
    }

    @PutMapping()
    public AjaxResponse updateArticle(@RequestBody ArticleVO articleVO) {
        articleService.updateArticle(articleVO);
        return AjaxResponse.sucess(articleVO);
    }

    @GetMapping("{id}")
    public AjaxResponse getArticleById(@PathVariable Integer id) {
        ArticleVO articleVO = articleService.getArticle(id);
        return AjaxResponse.sucess(articleVO);
    }

    @GetMapping()
    public AjaxResponse getAllArticles() {
        List<ArticleVO> articleVOList = articleService.getAllArticles();
        return AjaxResponse.sucess(articleVOList);
    }
}