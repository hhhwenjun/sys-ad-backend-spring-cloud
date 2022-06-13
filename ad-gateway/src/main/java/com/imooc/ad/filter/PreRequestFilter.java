package com.imooc.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {
    /**
     * Define type of filter
     * @return type of filter
     */
    @Override
    public String filterType(){
        return FilterConstants.PRE_TYPE;
    }

    /**
     * Define order of filer, low number mean high order
     * @return order of filer
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * Filter when under some certain conditions
     * @return true when should filter
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Operation of filters
     * @return request info
     * @throws ZuulException if exceptions
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());
        return null;
    }
}
