/**
 * Project Name: time-travle.github.io
 * File Name: SwaggerConfig
 * Package Name: org.joven.common.config
 * Date: 2020/5/4 20:27
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * CreateBy Administrator
 * Date: 2020/5/4 20:27
 * Version:
 * Remark: swagger2的配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.joven.common.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Common 工程中的rest 服务")
                .description("首次尝试自动生成api文档为后期的前后端分离开发做准备")
                .contact(new Contact("Joven", "https://time-travle.github.io/", "187631337197@163.com"))
                .version("1.0")
                .build();
    }
}
