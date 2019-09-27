package com.thinrain.springbootdemo.service;

import com.thinrain.springbootdemo.dao.ArticlePO;
import com.thinrain.springbootdemo.dao.ArticleRepository;
import com.thinrain.springbootdemo.model.ArticleVO;
import com.thinrain.springbootdemo.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    public ArticleVO addArticle(ArticleVO articleVO) {

        ArticlePO articlePO = dozerMapper.map(articleVO, ArticlePO.class);
        articleRepository.save(articlePO);

        return articleVO;
    }

    @Override
    public void delArticle(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        ArticlePO articlePO = dozerMapper.map(article, ArticlePO.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(Integer id) {
        Optional<ArticlePO> article = articleRepository.findById(id);
        return dozerMapper.map(article.get(), ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAllArticles() {
        List<ArticlePO> articleLis = articleRepository.findAll();

        return DozerUtils.mapList(articleLis, ArticleVO.class);

    }
}
