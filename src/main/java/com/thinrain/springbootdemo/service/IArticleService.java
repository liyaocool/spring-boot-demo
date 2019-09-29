package com.thinrain.springbootdemo.service;

import com.thinrain.springbootdemo.model.ArticleVO;

import java.util.List;

public interface IArticleService {
    public ArticleVO addArticle(ArticleVO articleVO);

    public void delArticle(Integer id);

    public void updateArticle(ArticleVO articleVO);

    public ArticleVO getArticle(Integer id);

    public List getAllArticles();
}
