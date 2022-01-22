##跨域请求解决方案
一般如下几种方案：https://zhuanlan.zhihu.com/p/50416743

    野路子出身却好用的方式：JSONP；
    官方推荐的跨域资源共享方案：CORS；
    使用HTML5 API：postMessage；
    抛弃HTTP，使用：Web Sockets
### 使用JSONP
浏览器的“同源策略”只是阻止了通过AJAX技术跨域获取资源，而并没有禁止跨域获取资源这件事本身，正因如此，
我们可以通过 link 标签， img 标签以及 script 标签中的href属性或src属性获取异域的CSS，JS资源和图片
（虽然我们其实并不能读取这些资源的内容）

 script标签通过src属性加载的JS资源，实际上只是将JS文件内容原封不动的放置在<scritp>的标签内
 这意味着被加载的文件与HTML文件下的其他JS文件共享一个全局作用域。
 也就是说，<scritp>标签加载到的资源是可以被全局作用域下的函数所使用的

我们已经约定好了数据的格式为JSON，这是JavaScript可以处理的数据类型，并且JSON格式的数据可以承载大量信息，
因为我们会通过向服务器传入一个函数的方式，将数据变为函数的参数

demo：

    1.    function handleResponse(response) {
    2.        alert(`You get the data : ${response}`)
    3.    }
    4.    const script = document.createElement('script')
    5.    script.src = 'http://somesite.com/json/?callback=handleResponse'
    6.    document.body.insertBefore(script, document.body.firstChild)
    在1-3行中创建了一个函数，该函数用来处理我们将要获得的数据，该函数的参数response即是服务器响应的数据。
    在4-6行中我们所做的是利用JavaScript动态生成一个script标签，并将其插入HTML文档。
    但是注意第5行我们制定的src值，在URL末尾，我们有这样一段查询参数callback=handleResponse，callback的值正是我们先前创建的函数。

在服务端的代码中，当服务端支持JSONP技术时，会做如下一些设置：

    1、识别请求的URL，提取callback参数的值，并动态生成一个执行该参数值（一个函数）的JavaScript语句；
    2、将需要返回的数据放入动态生成的函数中，等待其加在到页面时被执行；

当资源加载到位，内容显示在script标签内时，浏览器引擎会执行这条语句，我们想要的数据就可以被我们以任何想要的方式处理了

JSONP技术存在一下三点缺陷：

    1、无法发送POST请求，也就是说JSONP技术只能用于请求异域资源，无法上传数据或修改异域数据；
    2、无法监测JSONP请求是否失败；
    3、可能存在安全隐患：别忘了，JSONP之所以能成功获取异域服务器资源，靠的是服务器动态生成了回调函数，
        并在页面中执行，那么如果服务器在原有的回调函数下再添加些别的恶意JavaScript代码会怎样？当然也会被执行！
        所以在使用JSONP技术时，一定要确保请求资源的服务器是值得信赖的；

虽然存在一些缺陷，但JSONP的浏览器兼容性却是非常好的，可以说是一种非常小巧高效的跨域资源获取技术


###使用 官方推荐的跨域资源共享方案：CORS 的几种方案
方案一：使用@CrossOrigin注解

    在Controller上使用@CrossOrigin注解
    @CrossOrigin //所有域名均可访问该类下所有接口
    @CrossOrigin("https://blog.csdn.net") // 只有指定域名https://blog.csdn.net可以访问该类下所有接口
 
方案二：CORS全局配置-实现WebMvcConfigurer
跨域配置类：CorsConfig.java demo:
    
    /**
     * 跨域配置
     */
    @Configuration
    public class CorsConfig implements WebMvcConfigurer {
    
        @Bean
        public WebMvcConfigurer corsConfigurer()
        {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").
                            allowedOrigins("https://www.dustyblog.cn"). //允许跨域的域名，可以用*表示允许任何域名使用
                            allowedMethods("*"). //允许任何方法（post、get等）
                            allowedHeaders("*"). //允许任何请求头
                            allowCredentials(true). //带上cookie信息
                            exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
                }
            };
        }
    }

方案三：拦截器实现
实现Fiter接口在请求中添加一些Header来解决跨域的问题
demo：

    @Component
    public class CorsFilter implements Filter {
    
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletResponse res = (HttpServletResponse) response;
            res.addHeader("Access-Control-Allow-Credentials", "true");
            res.addHeader("Access-Control-Allow-Origin", "*");
            res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
            if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
                response.getWriter().println("ok");
                return;
            }
            chain.doFilter(request, response);
        }
        @Override
        public void destroy() {
        }
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }
    }


###Web Sockets 服务端与客户端的双向通信
当客户端与服务端创建WebSocket连接后，本身就可以天然的实现跨域资源共享，WebSocket协议本身就不受浏览器“同源策略”的限制

和使用XHRHttpRequest对象一样，我们首先要实例化一个WebSocket对象：
    
    var ws = new WebSocket("wss://echo.websocket.org")
    传入的参数为响应WebSocket请求的地址

同样类似AJAX的是，WebSocket对象也有一个readyState属性，用来表示对象实例当前所处的链接状态，有四个值：

    0：表示正在连接中（CONNECTING）；
    1：表示连接成功，可以通信（OPEN）；
    2：表示连接正在关闭（CLOSING）；
    3：表示连接已经关闭或打开连接失败（CLOSED）；
    我们可以通过判断这个值来执行我们相应的代码。

除此之外，WebSocket对象还提供给我们一系列事件属性，使我们控制连接过程中的通信行为：

    onopen：用于指定连接成功后的回调函数；
    onclose：用于指定连接关闭后的回调函数；
    onmessage：用于指定收到服务器数据后的回调函数；
    onerror：用于指定报错时的回调函数；

通过.send()方法，我们拥有了向服务器发送数据的能力（WebSocket还允许我们发送二进制数据）：

    ws.send('Hi, server!')
如何知道何时我们的数据发送完毕呢？

    我们需要使用WebSocket对象的bufferedAmount属性，
    该属性的返回值表示了还有多少字节的二进制数据没有发送出去，
    所以我们可以通过判断该值是否为0而确定数据是否发送结束。

    var data = new ArrayBuffer(1000000)
    ws.send(data)
    
    if (socket.bufferedAmount === 0) {
        // 发送完毕
    } else {
        // 还在发送
    }

### post Message
HTML5提供的新API -- postMessage 

postMessage技术实现跨域的原理：

    一方面，主窗口通过postMessageAPI向异域的窗口发送数据，
    另一方面我们在异域的页面脚本中始终监听message事件，
    当获取主窗口数据时处理数据或者以同样的方式返回数据从而实现跨窗口的异域通讯

demo：
页面现在有两个窗口，窗口1命名为“window_1”， 窗口2命名为“window_2”，
当然，窗口1与窗口2的“域”是不同的，我们的需求是由窗口1向窗口2发送数据，而当窗口2接收到数据时，将数据再返回给窗口1

窗口1script标签内的代码：

    // window_1 域名为 http://winodow1.com:8080
    window.postMessage("Hi, How are you!", "http://window2.com:8080")

可以看到，postMessage函数接收两个参数，

    第一个为要发送的信息（可以是任何JavaScript类型数据，但部分浏览器只支持字符串格式），
    第二个为信息发送的目标地址

窗口2script标签内的代码：

    // window_2 域名为 http://window2.com:8080
    window.addEventListener("message", receiveMessage, false)
    
    function receiveMessage(event) {
        // 对于Chorme，origin属性为originalEvent.origin属性
        var origin = event.origin || event.originalEvent.origin
        if (origin !== "http://window1.com:8080") {
            return 
        }
        window.postMessage("I\'m ok", "http://window1.com:8080")
    }
我们在window上绑定了一个事件监听函数，监听message事件。
一旦我们接收到其他域通过postMessage发送的信息，就会触发我们的receiveMessage回调函数。
该函数会首先检查发送信息的域是否是我们想要的（之后我们会对此详细说明），如果验证成功则会像窗口1发送一条消息。

看起来很好懂不是吗，一方发送信息，一方捕捉信息。但是，我需要格外提醒你的是所有“跨域”技术都需要关注的“安全问题”。
让我们想想postMessage技术之所以能实现跨域资源共享，本质上是要依赖于客户端脚本设置了相应的message监听事件。
因此只要有消息通过postMessage发送过来，我们的脚本都会接收并进行处理。由于任何域都可以通过postMessage发送跨域信息，
因此对于设置了事件监听器的页面来说，判断到达页面的信息是否是安全的是非常重要的事，因为我们并不想要执行有危险的数据。


如何鉴别发送至页面的信息呢？

    通过 message事件监听函数的事件对象，我们称它为event，该对象有三个属性：
    data：值为其他window传递过来的对象；
    origin：值为消息发送方窗口的域名；
    source：值为对发送消息的窗口对象的引用；

很显然的，我们应该着重检测event对象的origin属性，建立一个白名单对origin属性进行检测通常是一个明智的做法


