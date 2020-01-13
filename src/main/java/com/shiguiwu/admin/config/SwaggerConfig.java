package com.shiguiwu.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 接口文档、
 * @author: stone
 * @date: Created by 2020/1/13 21:38
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin.config
 */
@Configuration
//声明该类为配置类
@EnableSwagger2
//声明启动Swagger2

public class SwaggerConfig {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shiguiwu.admin.controller"))//扫描的包路径
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DCC API接口")//文档说明
                .version("1.0.0")//文档版本说明
                .build();
    }

}
