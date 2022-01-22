/**
 * Project Name: time-travle.github.io
 * File Name: MvcConfigCustomer
 * Package Name: org.joven.common.config
 * Date: 2020/5/4 21:21
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * CreateBy Administrator
 * Date: 2020/5/4 21:21
 * Version: 1.0
 * Remark: Spring Boot自動配置本身不會自動把/swagger-ui.html這個路徑對映到對應的目錄META-INF/resources/下面。我們加上這個對映即可
 * https://blog.csdn.net/lovequanquqn/article/details/90705721
 * https://blog.csdn.net/neulily2005/article/details/83788725
 */
@Configuration
public class WebMvcConfigCustomer extends WebMvcConfigurationSupport {

    /**
     * fixed question: No mapping for GET /Common/swagger-ui.html
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     *
     * @param registry req
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");*/
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
