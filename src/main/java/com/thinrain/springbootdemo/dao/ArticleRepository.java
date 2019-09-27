package com.thinrain.springbootdemo.dao;

import com.thinrain.springbootdemo.model.ArticleVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticlePO,Integer> {
    ArticlePO findByAuthor(String author);
}