##Q1：如何配置搭建使用Feign 

参考wiki：

https://www.cnblogs.com/feifuzeng/p/13613732.html

https://www.jianshu.com/p/8bca50cb11d8

http://c.biancheng.net/view/5357.html


##Q2 Feign 和 Ribbon 的区别
Ribbon：

    是一个基于 HTTP 和 TCP 客户端 的负载均衡的工具。
    它可以 在客户端 配置 RibbonServerList（服务端列表），使用 HttpClient 或 RestTemplate 模拟http请求，步骤相当繁琐。

Feign：

    Feign 是在 Ribbon的基础上进行了一次改进，是一个使用起来更加方便的 HTTP 客户端。
    采用接口的方式， 只需要创建一个接口，然后在上面添加注解即可 ，将需要调用的其他服务的方法定义成抽象方法即可， 不需要自己构建http请求。
    然后就像是调用自身工程的方法调用，而感觉不到是调用远程方法，使得编写 客户端变得非常容易。

代码方面的用法区别：

    Ribbon：用 REST_URL_PREFIX 指定请求地址 ， 使用 restTemplate 模拟 http 请求。也就是说需要自己来构建发起HTTP请求
    Feign：
        a) 新建一个接口，添加@FeignClient 注解，指定微服务名称 MICROSERVICECLOUD-DEPT
        b) 指定请求地址 @RequestMapping

参考：

https://www.cnblogs.com/tongxuping/p/12297964.html

https://www.cnblogs.com/linkworld/p/9191161.html

##如何优雅的开启 Feign 对 Hystrix 的支持
OpenFeign 是 自带 Hystrix ，但是默认没有打开
先添加了Hystrix 的pom依赖， 然后在属性文件中开启 Feign 对 Hystrix 的支持：
    feign.hystrix.enabled=true

##如何优雅的关闭 Feign 对 Hystrix 的支持
禁用 Hystrix 还是 比较简单的，目前有两种方式可以禁用 ， 其中一种是在属性文件中进行全部禁用 。
feign.hystrix.enabled=false 

另一种是通过代码 的方式禁用某个客户端 ， 在 Feign 的配置类中 增加代码
    @Configuration 
    public  class  FeignConfiguration { 
        @Bean 
        @Scope ("prototype") 
        public Feign.Builder feignBuilder() { 
            return  Feign.builder(); 
        }
    }


