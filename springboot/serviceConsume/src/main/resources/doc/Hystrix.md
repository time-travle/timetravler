##  Hystrix 后的远程调用流程
简单的流程如下 ：
1 ）构建 HystrixCommand 或者 Hys trixObservableCom mand 对象 。
2 ）执行命令。
3 ）检查是否有相同命令执行的缓存。
4 ）检查断路器是否打开。
5 ）检查线程池或者信号量是否被消耗完 。
6 ）调用 HystrixObservableCommand#construct 或 HystrixCommand#run 执行被封装的远程调用逻辑 。
7 ）计算链路的健康情况 。
8 ）在命令执行失败时获取 Fallback 逻辑 。
9 ）返回成功的 Observable 。

## 如何开启 Hystrix
在启动类上添加＠EnableHystrix 或者＠EnableCircuitBreaker 。 注意，＠EnableHystrix中包含了＠EnableCircuitBreaker 。

## Feign 整合 Hystrix 服务容错
处理的方式 
Fallback 方式
    在Feign 的客户端类 上的 ＠FeignClient 注解 中指 定 fallback 进行回退
    不过是实现的类中要继承这个FeignClient类同时实现里面的方法，方法内容就是当对应的服务是挂的时候的处理逻辑，
    相比不和Feign融合，和Feign融合后配置的异常处理时机相对靠后一点点。
    一般使用这种方式都是构造一个没有值值的对象返回去，这样可以确保走到这里服务是没挂掉的，这时可以记录日志下来，后再进行处理
    
   使用这个方式时我们就不关注异常的原因了，不管异常原因是啥我们都是直接执行我们预设置的逻辑 ，
   但是对于一个开发来说这明显是不可能的，有问题不记录，不处理是不对，这是我们就用到了第二种的处理方式

FallbackFactory 方式
使用就是在＠FeignClient 中用 fallbackFactory 指定回退处理类 
这个工厂类FallbackFactory实现 FallbackFactory

##Hystrix 监控 如何使用 （单节点监控）
在微服务架构中， Hystrix 除了实现容错外，还提供了 实 时监控功能。 
在服务调用时，Hystrix 会实时累积关于 HystrixCommand 的执行信息，比如每秒的请求数、 成功数等

看官方文档地址：https://github.com/Netflix/Hystrix/wiki/Metrics-and-Monitoring


必备条件：
 <!--健康检查-->
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-actuator</artifactId>
 </dependency>
 <!--Hystrix 服务容锚处理 -->
 <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
 </dependency>
 
 demo：
 这样调用一下cal!Hello 接口 http://localhost:8082/substitution/cal!Hello ,
 访问之后就可以看到 http://localhost:8082/hystrix.stream 这个页面中输出的数据了
 
 ## 不满足使用 hystrix.stream 俩查看监控数据时  喜欢使用图形话就可以使用监控面板了  （单节点监控）
 添加对应的依赖
 <!--整合 Dashboard 查看监控数据-->
 <dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
 </dependency>
 
之后在启动类上添加 ＠EnableHystrixDashboard 注解

启动服务，访问 http://ip:port/hystrix 可以看到 dashboard 的主页
主页中有 3 个地方需要我们填写，
第一行是监控的 stream 地址，也就是将之前文字监控信息的地址（http://localhost:8082/hystrix.stream）输入到第一个文本框中 。
第二行的 Delay 是时间，表示用多少毫秒同步一次监控信息， 
第三个地方 Title 是标题，这个可以随便填写，
 
## 聚合监控工具Turbine （简单描述）
 Turbine 是聚合服务器发送事件流数据的一个工具。 Hystrix 只能监控单个节点，然后通
 过 dashboard 进行展示 。 实际生产中都为集群，这个时候我们可以通过 Turb ine 来监控集群
 下 Hystrix 的 metrics 情况，通过 Eureka 来发现 Hystrix 服务
 
 POM
 <dependency> 
    <groupId>org.springframework.cloud</groupId>
    <artifactid>spring-cloud-starter-turbine</artifactid>
 </dependency> 
 启动类上增加＠Enable Turbine 和＠EnableDiscoveryClient
 
 属性文件中配置如下内容：
 eureka.client.serviceUrl.defaultZone=http://yinjihuan:123456@master:B761/eureka/ 
 turbine.appConfig=fsh-substitution,fsh-house 
 turbine.aggregator.clusterConfig=default 
 turbine.clusterNameExpression=new  String ("default")
 
  其中 ：
  •  turbine.appConfig ：配置需要聚合的服务名称 。
  •  turbine.aggregator.clusterConfig:  Turbine 需要聚合的集群名称
  •  turbine.clusterNameExpression ：集群名表达式。
重启服务，就可以使用 http://localhost:90 ! ! /turbine.stream 来访问集群的监控数据了 。
Turbine 会通过在 Eureka 中查找服务的 homePageUrl 加上 hystrix.stream 来获取其他服务的
监控数据，并将其汇总显示  

context-path 导致监控失败
如果被监控的服务中设置了 context-path ，则会导致 Turbine 无法获 取监控数据

这个时候需要在 Turbine 中指定 turbine.instanceUr!Suffix 来解决这个问题：
turbine .instanceUrlSuffix=/sub/hystrix.stream 
sub 用于监控服务的 context-path 。 上面这种方式是全局配置，会有一个问题，就是一
般我们在使用中会用 一个集群去监控多个服务，如果每个服务的 context-path 都不一样，
这个时候有一些就会出问题，那么就需要对每个服务做一个集群，然后配置集群对应的
context-path: 
turbine.instanceUrlSuffix. 集群名称＝／sub/hystrix.stream

