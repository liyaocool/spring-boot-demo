package com.thinrain.springbootdemo.jpa;

import com.thinrain.springbootdemo.dao.ArticlePO;
import com.thinrain.springbootdemo.dao.ArticleRepository;
import com.thinrain.springbootdemo.model.ArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
        ArticlePO articlePO = articleRepository.findByAuthor("石玉");
        System.out.println(articlePO);
    }

}