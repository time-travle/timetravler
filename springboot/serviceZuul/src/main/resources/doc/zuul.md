##Q1: Zuul 转发规则
当 Zuul 集成 Eureka 之后，其实就可以为 Eureka 中所有的服务进行路由操作了， 默认的转发规则就是“API网关地址＋访问的服务名称 ＋接口URI” 。 
    在给服务指定名称的时候，应尽量短一点，这样的话我们就可以用默认的路由规则进行请求，
    不需要为每个服务都定一个路由规则，这样就算新增了服务， API 网关也不用修改和重启了 
        
    指定具体服务路由   我们可以为每一个服务都配置一个路由转发规则    
        zuul.routes.sh-house.path=/sh-house/** 
        zuul.routes.sh-house.url=http://sh-house.com/ 
    
        这边 api-house ／材后面一定要配置两个星号，两个星号表示
        可以转发任意层级的 URL ，比如“/api-house/house/l ” 。 如果只配置一个星号，那么就只能转发一级， 比如“ /api-house/house ”
        
    路由前缀
        比如 http://cxytiandi.com/user/login 这是
        一个登录的接口，现在想将其变成 http://cxytiandi.com/rest/user/login ，即在每个接口前面
        加一个 rest ， 此时我们可以通过 Zuul 中的配置来进行实现 ：
        zuul.prefix=/rest 
        
    本地跳转
        Zuul 的 API 路由还提供了本地跳转功能，通过 forward 就可以实现。
        zuul.routes.fsh-substitution.path=/api/** 
        zuul.routes.fsh-substitution.url=forward:/local 
        
        当我们想在访问 api/J 的时候会路由到本地的 local/l 上去，就可参照上述代码实现。
        local 这个接口需要我们自行添加，其是本地接口，故我们要建一个 Controller 
        
        @RestController 
        public class  LocalController  { 
            @GetMapping (”/local/{id}”) 
            public  String  local(@PathVariable  String  id)  { 
                return  id; 
            }
        }
        然后访问 http://localhost:2l03/api/1 就可以看到我们想要的返回结果了
        
## Q2: Zuul过滤器 使用     
Zuul 中的过滤器总共有 4 种类型，每种类型都有对应的使用场景 。

    •  pre ：可以在请求被路由之前调用 。 
            适用于身份认证的场景，认证通过后再继续执行下面的流程。
    •  route  ：在路由请求时被调用 。 
            适用于灰度发布场景，在将要路由的时候可以做一些自定义 的逻辑 。
    •  post ：在 route 和 error 过滤器之后被调用 。 
            速种过滤器将请求路由到达具体的服务之后执行。 适用于需要添加响应头，记录响应日志等应用场景。
    •  error ：处理请求时发生错误时被调用 。 
            在执行过程中发送错误时会进入 error 过滤器，可以用来统一记录错误信息

    请求发过来首先到 pre 过滤器，再到 route 过滤器 ，
    最后到 post 过滤器，任何一个过滤器有异常都会进入 error 过滤器
     https://github.com/Netflix/zuul/wiki/How-it-Works
            
##Q3: Zuul 的核心是过滤器，
通过这些过滤器我们可以扩展出很多功能，比如 ：

    ·动态路由：动态地将客户端的请求路由到后端不同的服务，做一些逻辑处理，比如聚合多个服务的数据返回 。
    
    ·请求监控：可以对整个系统的请求进行监控，记录详细的请求响应日志，可以实时统计出当前系统的访问量以及监控状态 。      
    
    ·认证鉴权：对每一个访问的请求做认证，拒绝非法请求，保护好后端的服务。
    
    ·压力测试：压力测试是一项很重要 的 工作，像一些电商公司需要模拟更多真实的用户并发量来保证重大活动时系统的稳定。
              通过 Zuul 可以动态地将请求转发到后端服务的集群中，还可以识别测试流量和真实流量，从而做一些特殊处理。
    
    ·灰度发布：灰度发布可以保证整体系统的稳定，在初始灰度 的时候就可以发现 、调整问题，以保证其影响度 。
    
##Q4: 过滤器禁用

    可以采取下面的两种方式来实现：
        ·利用 shouldFilter 方法中的 return false 让过滤器不再执行
        ·通过配置方式来禁用过滤器，格式为“zuul.过滤器的类名．过滤器类型.disable=true” 。

##Q5： 自定义过滤器 的使用
    自定义过滤器需要继承 ZuulFilter ， 并且需要实现下面几个方法：
    •  shou ldFilter ： 是否执行该过滤器 ， true 为执行， false 为不执行，这个也可以利用配
    置中心来实现，达到动态的开启和关闭过滤器 。
    •  filterType ：过滤器类型，可选值有 pre 、 route 、 post 、 error 。
    •  filterOrder ：过滤器的执行顺序，数值越小 ，优先级越高。
    •  run ：执行自己的业务逻辑，

##Q6： 过滤器中的数据传递
    项目中往往会存在很多的过滤器，执行的顺序是根据 filterOrder 决定的，那么肯定有一些过滤器是在后面执行的 ，
        如果你有这样的需求 ：第一个过滤器需要告诉第二个过滤器一些信息，这个时候就涉及过滤器中怎么去传递数据给后面的过滤器 。
        实现这种传值的方式笔者第一时间就想到了用 ThreadLocal ，既然我们用 了 Zuul ，那么Zuul 肯定有解决方案，
        比如可以通过 RequestContext 的 set 方法进行传递， RequestContext的原理就是 ThreadLocal 
    
    RequestContext  ctx  =  RequestContext.getCurrentContext(); 
    ctx.set （” msg ”，” 你好吗 ”）；
    后面的过滤就可以通过 RequestContext 的 get 方法来获取数据：
    RequestContext  ctx  =  RequestContext.getCurrentContext(); 
    ctx.get (”msg”); 
    
    完整源码请参考： com.netflix . zuul.context.RequestContext 。
    
##Q7：  如何进行过滤器拦截请求
    拦截和返回结果只需要 4 行代码即可实现
    RequestContext ctx = RequestContext.getCurrentContext();
    ctx.setSendZuulResponse(false); 告诉 Zuul 不需要将当前请求转发到后端的服务 源码：org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter
    ctx.set("sendForwardFilter.ran", true);是用来拦截本地转发请求的，当我们配置了 forward：/local 的路由，ctx.setSendZuulResponse(false) 对 forward 是不起作用的，需要设置 ctx.set("sendForwardFilter.ran"，true) 才行
    ctx.setResponseBody("返回信息");
    return null;   
    
##Q8： 多个拦截器同时执行时 如何在一个成功拦截后其他的不再执行
    ctx.setSendZuu!Response(false）告诉 Zuul 不需要将当前请求转发到后端的服务。 到
    这一步之后，当前的过滤器中确实将请求进行拦截了，并且可以给客户端返回信息 。 但是
    当你的项目 中有多个过滤器的时候，假如你需要过滤的那个过滤器是第一个执行的，发现
    非法请求，然后进行拦截，进行拦截之后，在chain.doFilter 之前进行返回就可以让过滤器不往下执行 了 。 
    但是 Zuul 中的过滤器不一样，即使你刚刚通过 ctx.setSendZuu!Response (false）设置了不路由到服务，并且返回 null ，
    那只是当前的过滤器执行完成了，后面还有很多过滤器在等着执行。
    
    使用zuul时我们可以在shouldFilter 这个方法中判断是不是需要执行当前的过滤器，判断的依据可以利用Q6中的传值的方式进行
    ，用一个字段来表示要不要继续执行下面的过滤器，使得全部的过滤器形成一个链条一样的形式。

## Q9: 过滤器中的异常
过滤器中的异常主要发生在 run 方法中，

     可以用 try catch 来处理。 Zuul 中也为我们提供了一个异常处理的过滤器，当过滤器在执行
     过程中发生异常，若没有被捕获到，就会进入 error 过滤器中 

## Q10:Zuul 高可用
用额外的负载均衡器来实现 Zuul的高可用
     最常用的 Nginx ，或者 HAProxy 、 FS 等
    
##QQ: 其他
不论是什么请求，只有经过zuul都会执行一篇所有的过滤拦截，顺序是根据filterOrder（）方法的返回值来判定的 ，通过返回的正整数值来定义过滤器的执行顺序，数字越小优先级越高
    
    因此 ，在每层过滤文件需要做判断这个请求是否需要开启这个过滤的操作逻辑
如果配合eureka ，可使用远程服务名的全小写为路由关键字来映射到指定的远程服务去，
   
    如果远程服务名 为 conSUmer-9001
    
    不可使用 
    
    #http://localhost:5001/mzuul/CONSUMER-9001/gettname
    或
    #http://localhost:5001/mzuul/conSUmer-9001/gettname
    必须写成全小写
    
    #http://localhost:5001/mzuul/consumer-9001/gettname
    但是必须开启默认路由 ，不写这个配置即可 ，默认使用默认路由
    
    #忽略所有的，表示禁用默认路由，只认我们自己配置的路由.
    #zuul.ignored-services="*"
    
前缀不可以使用zuul 
    
    zuul.prefix=/mzuul
    
    
    