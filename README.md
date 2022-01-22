# 简单说明
基于springboot 进行分布式 服务的开发

区分后台管理界面和对应的客户使用界面，使用不同的链接，代码使用不同的技术架构

修改host文件：
    追加: ip指定对应的IP地址即可
    127.0.0.1 center-master
    127.0.0.1 center-second
    127.0.0.1 center-third
#总体技术架构规划如下V1：
##前端运营页：
    使用VUE技术开发（使用目前小微企业常用框架）
##前端管理页：
    使用Angular技术开发（大型复杂框架）

##前后端通信模式：
    使用Nginx进行反向代理访问

##后端采用Springboot+SpringCloud技术框架
    0、公共工具类，公共配置工程，不提供服务功能
    1、服务中心采用Eureka 或者Zookeeper
    2、后端服务统一出口采用Gateway，同时做登录鉴权,登录限制
    3、统一子服务调用模式，若无必要要求，统一使用Fegin调用模式
    4、预置服务工程-系统服务（system）
    5、预置服务工程-缓存管理服务（cache）
    6、预置服务工程-通用服务（common）
    7、预置服务工程-定时任务服务（schedule）使用quartz框架，开启集群模式
    8、预置服务工程-消息发布接受（RabbitMQ、Spring BUS）
    9、预置服务工程-WS消息服务（WebSocket）
    10、预置服务工程-文件管理服务（File Management）
    11、预置服务工程-邮件发送服务（Email）
    12、数据库采用MYSQL和Oracle混合式，各服务按需使用，同时开动自动备份功能
    13、搭建Maven私服
    
###后端注意点：
    1、系统提供高并发支持
    2、数据定期备份
    3、数据报表功能支持（
            JasperReports https://community.jaspersoft.com/community-download 、
            iReport https://community.jaspersoft.com/project/ireport-designer/releases
            ）
    4、服务支持容器化部署
    5、文件资源的上传和下载
    6、后端服务集群部署
    7、消息中间件的消息下发

#总体技术架构规划V2：
在V2的基础上1+n定制开发

#总体技术架构规划V3：
进行插件开发

Java 插件工程开发的概念
https://blog.csdn.net/pl0528/article/details/5619006

Java系统插件开发原理与实例
https://blog.csdn.net/ccboy2009/article/details/41833241

java插件化开发
https://blog.csdn.net/u010675669/article/details/86677540

简单开发一个java 插件式demo
https://blog.csdn.net/zhouzhiwengang/article/details/72772259

