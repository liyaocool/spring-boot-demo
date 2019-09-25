package com.thinrain.springbootdemo.restful;

import com.thinrain.springbootdemo.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@Transactional
@Slf4j
@SpringBootTest
public class ArticleControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

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

        //发送请求的路径方法,携带参数,期待返回的数据和实际返回的数据对比,不对等则报错
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/articles")
                        .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("白自在"))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }

    @Test
    public void getArticle() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.GET, "/articles/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("小虾米"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.title").value("笑傲江湖"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content").value("令狐冲的独孤九剑"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].name").value("zhangsan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value("19"))
                .andDo(print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}