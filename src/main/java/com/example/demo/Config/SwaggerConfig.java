package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
//@EnableWebMvc
////配置生产环境下不可用  dev(开发)、test(测试)、prod(生产)
//@Profile({"dev","test"})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                // DocumentationType.SWAGGER_2 固定的，代表swagger2
                //.groupName("分布式任务系统")
                // 如果配置多个文档的时候，那么需要配置groupName来分组标识
                .select()
                // select()函数返回一个ApiSelectorBuilder实例,用来控制接口被swagger做成文档
                // 扫描指定包下的接口，最为常用
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.Controller"))
                .paths(PathSelectors.any())
                        //.any() // 满足条件的路径，该断言总为true
                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
                        //.ant("/user/**") // 满足字符串表达式路径
                        //.regex("") // 符合正则的路径
                //DocumentationType.SWAGGER_2 固定的，代表swagger2
                //.groupName("分布式任务系统") // 如果配置多个文档的时候，那么需要配置groupName来分组标识
                .build()
                .apiInfo(apiInfo());// 用于生成API信息



    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api文档")
                .description("Api文档")
                .version("0.0.1")
                .build();

    }
}