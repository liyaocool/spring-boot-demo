package com.thinrain.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createArticleApi() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thinrain.springbootdemo"))
                .paths(PathSelectors.regex("/articles"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Restful风格Api文档")
                .description("使用swagger构建动态更新的Api文档")
                .termsOfServiceUrl("https:www.thinrain.com")
                .version("1.0")
                .build();
    }
}
