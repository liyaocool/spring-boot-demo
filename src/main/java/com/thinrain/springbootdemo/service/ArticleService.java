package com.thinrain.springbootdemo.service;

import com.thinrain.springbootdemo.generator.Article;
import com.thinrain.springbootdemo.generator.ArticleMapper;
import com.thinrain.springbootdemo.model.ArticleVO;
import com.thinrain.springbootdemo.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleService implements IArticleService {
    @Resource
    private Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public ArticleVO addArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.insert(articlePO);
        return null;
    }

    @Override
    public void delArticle(Integer id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Integer id) {
        Article article = articleMapper.selectByPrimaryKey(id);
        return dozerMapper.map(article, ArticleVO.class);
    }

    @Override
    public List getAllArticles() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
