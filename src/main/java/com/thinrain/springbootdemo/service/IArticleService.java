package com.thinrain.springbootdemo.service;

import com.thinrain.springbootdemo.model.ArticleVO;

import java.util.List;

public interface IArticleService {

     ArticleVO addArticle(ArticleVO article);

     void delArticle(Integer id);

     void updateArticle(ArticleVO article);

     ArticleVO getArticle(Integer id);

     List<ArticleVO> getAllArticles();
}