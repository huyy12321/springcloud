package com.hyy.zuul.config;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author hyy
 */
@Configuration
@Slf4j
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest req = (HttpServletRequest) RequestContext.getCurrentContext().getRequest();
        System.out.println("-----------日志过滤器启用------------------");
        return null;
    }
}
