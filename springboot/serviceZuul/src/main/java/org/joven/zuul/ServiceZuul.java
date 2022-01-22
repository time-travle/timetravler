package org.joven.zuul;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 通过＠EnableZuulProxy 开启路由代理功能  EnableZuulProxy 已经自带了＠EnableDiscoveryClient
 * EnableDiscoveryClient 注册到服务注册中心
 */
@EnableZuulProxy
// 到进来的数据库配置全忽略
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class ,
        HibernateJpaAutoConfiguration.class})
public class ServiceZuul {
    public static void main(String[] args) {
        SpringApplication.run(ServiceZuul.class, args);
    }
}
