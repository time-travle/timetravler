package org.joven.zuul.config;

import org.joven.zuul.filter.ErrorFilter;
import org.joven.zuul.filter.IpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的过滤器 并不会直接生效 我们还需要为其创建bean才可以启动过滤器
 * 不单独拉出来定义也可以在启动类中使用注解注入
 */
@Configuration
public class ZuulConfig {
    @Bean
    public IpFilter ipFilter() {
        return new IpFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
