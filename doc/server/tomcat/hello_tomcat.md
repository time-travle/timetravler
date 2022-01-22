#Tomcat

轻量级应用服务器。
Tomcat是应用(Java)服务器，它只是一个Servlet(JSP也翻译成Servlet)容器，可以认为是Apache的扩展，但是可以独立于Apache运行。
缺点：可以说Tomcat 只能用做java服务器
优点：动态解析容器，处理动态请求，是编译JSP/Servlet的容器。

三个端口：
8005：关闭tomcat通信接口
8009：与其他http服务器通信接口，用于http服务器集合
8080：建立http连接 用，如浏览器访问

Tomcat虽然是一个servlet和jsp容器，但是它也是一个轻量级的web服务器。它既可以处理动态内容，也可以处理静态内容。不过，tomcat的最大优势在于处理动态请求，处理静态内容的能力不如apache和nginx，并且经过测试发现，tomcat在高并发的场景下，其接受的最大并发连接数是有限制的，连接数过多会导致tomcat处于"僵死"状态，因此，在这种情况下，我们可以利用nginx的高并发，低消耗的特点与tomcat一起使用。因此，tomcat与nginx、apache结合使用共有如下几点原因：
1、tomcat处理html的能力不如Apache和nginx，tomcat处理静态内容的速度不如apache和nginx。
2、tomcat接受的最大并发数有限，连接数过多，会导致tomcat处于"僵尸"状态，对后续的连接失去响应，需要结合nginx一起使用。

通常情况下，tomcat与nginx、Apache结合使用，nginx、apache既可以提供web服务，也可以转发动态请求至tomcat服务器上。但在一个高性能的站点上，通常nginx、apache只提供代理的功能，也就是转发请求至tomcat服务器上，而对于静态内容的响应，则由前端负载均衡器来转发至专门的静态服务器上进行处理
在这种架构中，当haproxy或nginx作为前端代理时，如果是静态内容，如html、css等内容，则直接交给静态服务器处理；如果请求的图片等内容，则直接交给图片服务器处理；如果请求的是动态内容，则交给tomcat服务器处理，不过在tomcat服务器上，同时运行着nginx服务器，此时的nginx作为静态服务器，它不处理静态请求，它的作用主要是接受请求，并将请求转发给tomcat服务器的，除此之外，nginx没有任何作用。
————————————————
版权声明：本文为CSDN博主「Lincyou」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44221613/java/article/details/88410701

