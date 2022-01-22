##如何搭建使用Ribbon
Ribbon 是在客户端实现负载均衡的
    经过网络查看多个不同的用例，发现在springboot中使用这个组件的大部分是和结合RestTemplate 的直接单独的使用的情况使用较少。
    这里就不表述单独的使用方法了
    下面直接说如何和这个 RestTemplate 进行结合
    
    
   首先引入POM
   
       <dependency>
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
       </dependency> 
       或者是
       <dependency> 
           <groupId>org.springframework.cloud</groupId>
           <artifactId>spring-cloud-starter-ribbon</artifactId> 
       </dependency>
       
   修改一下 RestTemplate 的实体获取方法 使用注释LoadBalanced开始负载均衡 如是不用这个我们调用服务是写的对应的服务名或只是一个IP 
   是起不到负载均衡的目的
   
       @Bean
       @LoadBalanced
       public RestTemplate getRestTemplate() {
           return new RestTemplate();
       }
           
   RestTemplate 常用的方法大致如下：
     
     public  <T>  T  getForObject(String  url,  Class<T>  responseType, Object ...  uriVariables); 
     public  <T>  T  getForObject(String  url,  Class<T>  responseType, Map<String,  ?>  uriVariables); 
     public  <T>  T  getForObject(URI  url,  Class<T>  responseType);
     
     public  <T>  T  postForObject(String  url,  Object  request, Class<T>  responseType,  Object ...  uriVariables); 
     public  <T>  T  postForObject(String  url,  Object  request, Class<T>  responseType,  Map<String,  ?>  uriVariables); 
     public  <T>  T  postForObject(URI  url,  Object  request,  Class<T>  responseType);
    
