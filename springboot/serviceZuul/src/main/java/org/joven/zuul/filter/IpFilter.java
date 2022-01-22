package org.joven.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 一个 pre 类型的 IP自定义过滤器
 * 自定义过滤器需要继承 ZuulFilter
 */
@Slf4j
public class IpFilter extends ZuulFilter {

    //private BasicConf basicConf;

    /**
     * 过滤器类型，可选值有 pre 、 route 、 post 、 error 。
     *
     * @return 类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，数值越小 ，优先级越高。
     *
     * @return 执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器 ， true 为执行， false 为不执行，这个也可以利用配
     * 置中心来实现，达到动态的开启和关闭过滤器
     *
     * @return 是不是执行过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行自己的业务逻辑
     * RequestContext 的原理就是 ThreadLocal
     *
     * @return 逻辑
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getRequest();
        log.debug("IpFilter:{}", ctx);
        return null;

    }
}
