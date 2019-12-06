package com.hyy.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * @author hyy
 */
@Component
public class IpFilter extends ZuulFilter {


    public IpFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        // 是否开启过滤器
        RequestContext ctx = RequestContext.getCurrentContext();
        Object success = ctx.get("isSuccess");
        return success == null ? true : Boolean.parseBoolean(success.toString());
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器执行顺序
        return 1;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        System.out.println("------------"+ctx.getRequest().toString()+"--------------------------");
        // 往过滤器中添加参数，之后的过滤器可以取  原理就是 ThreadLocal
        ctx.set("msg", "你好吗");
        // 模拟拒绝访问操作
//        ctx.setSendZuulResponse(false);
//        ctx.set("sendForwardFilter.ran", true);
        // 设置之后的过滤器不执行
//        ctx.set("isSuccess", false);
//        ctx.setResponseBody("error message");
        return null;
    }
}