package org.joven.consume;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * EnableDiscoveryClient 表示当前服务是一个 Eureka 的客户端 向注册中心上注册服务
 *      EnableEurekaClient 只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心
 * EnableFeignClients 表示当前服务开启了 使用Feign调用服务接口
 *      扫描有FeignClient 注解的接口类
 * EnableHystrix 当前服务开启容错功能
 *      EnableHystrix 中包含了 EnableCircuitBreaker 。
 *
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
// 到进来的数据库配置全忽略--练习项目 不用数据库
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class ,
        HibernateJpaAutoConfiguration.class})
public class ServiceConsume {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsume.class, args);
    }
}
