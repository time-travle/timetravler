package org.joven.consume.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /**
     * LoadBalanced 这个注解会自动构造 LoadBalancerClient 开启负载客户端负载均衡接口的实现类并注册到 Spring 容器中
     * 使用了这个后 测试不能直接用了必须通过中心
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        //return new RestTemplate();
        // 自定义RestTemplate实例 https://blog.csdn.net/zhanglf02/article/details/89842372
        return new RestTemplate(httpRequestFactory());
    }
    /*
一个疑问：为什么在 RestTemplate 上加了一个＠LoadBalanced 之后，RestTemplate 就能够跟 Eureka 结合了，可以使用服务名称去调用接口，还可以负载均衡？

    这功劳应归于 Spring Cloud 给我们做了大量的底层工作，因为它将这些都封装好了，我们用起来才会那么简单。
    框架就是为了简化代码，提高效率而产生的 。
    主要的逻辑就是给 RestTemplate 增加拦截器，在请求之前对请求的地址进行替换，或
    者根据具体的负载策略选择服务地址 ，然后再去调用 ，这就是＠LoadBalanced 的原理。
     */
    /*
ribbon 常用配置:
    1 禁用 Eureka
    当 我们在 RestTemplate 上添加 ＠LoadBalanced 注解后，就可 以用服务名 称来调用接口
    了 ， 当有多个服务 的时候，还能做负载均衡。 这是因为 Eur eka 中的服务信息 已 经被拉取到
    了客户端本地 ， 如果我们不想和 Eureka 集成， 可以通过下面的配置方法将其禁用 。
    ＃ 禁用 Eureka
    ribbon.Eureka.enabled=false

    2 当 我们禁用 了 Eureka 之后，就不能使用服务名称去调用接口了 ， 必须指定服务地址。
    禁用之后就需要手动配置调 用的服务地址了， 配置如下：
    ＃ 禁用 Eureka 后手动配置服务地址
    fsh-house.ribbon.listOfServers=localhost:8081,localhost:8083
    这个配置是针对具体服务的，前缀就是服务名称 ， 配置完之后就可以和之前一样使用服务名称来调用接口了

    3 配置负载均衡策略
    ＃ 配置负载均衡策略
    fsh-house.ribbon.NFLoadBalancerRuleClassName=com.netfl工x.loadbalancer.RandomRule

    4 超时时间
    Ribbon 中有两种时间相关的设置， 分别是请求连接的超时时间和请求处理的超时时间，设置规则如下：
    ＃ 请求连接的超时时间
    ribbon.connectTimeout=2000
    ＃ 请求处理的超时时间
    ribbon.readTimeout=5OOO


     */


    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    public HttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        //设置整个连接池最大连接数 根据自己的场景决定
        connectionManager.setMaxTotal(100);
        //路由是对maxTotal的细分
        connectionManager.setDefaultMaxPerRoute(100);
        RequestConfig requestConfig = RequestConfig.custom()
                //服务器返回数据(response)的时间，超过该时间抛出read timeout
                .setSocketTimeout(10000)
                //连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
                .setConnectTimeout(5000)
                //从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
                // 会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .setConnectionRequestTimeout(1000)
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }
}
