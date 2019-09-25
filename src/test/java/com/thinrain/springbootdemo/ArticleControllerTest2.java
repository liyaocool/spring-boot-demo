package com.thinrain.springbootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinrain.springbootdemo.controller.ArticleController;
import com.thinrain.springbootdemo.model.Article;
import com.thinrain.springbootdemo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest2 {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void addArticle() throws Exception {
        //模拟假数据 json
        String article = "{" +
                "    \"id\": 1, " +
                "    \"author\": \"白自在\",   " +
                "    \"title\": \" 侠客岛喝腊八粥\",   " +
                "    \"content\": \"侠客岛喝腊八粥...\",   " +
                "    \"createTime\": \"2017-07-16 05:23:34\"    " +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article, Article.class);

        //打桩,当运行到某个程序时,直接返回 固定不动的值,here is ok
        when(articleService.addArticle(articleObj)).thenReturn("here is ok");

        //发送请求的路径方法,携带参数,期待返回的数据和实际返回的数据对比,不对等则报错
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/articles")
                    .contentType("application/json").content(article))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("白自在"))
                    .andDo(print())
                    .andReturn();

        log.info(result.getResponse().getContentAsString());

    }
}