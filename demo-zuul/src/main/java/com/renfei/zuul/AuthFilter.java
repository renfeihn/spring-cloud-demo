package com.renfei.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();

        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            rc.setSendZuulResponse(true); //对请求进行路由
            rc.setResponseStatusCode(200);
            rc.set("isSuccess", true);
            return null;
        } else {
            rc.setSendZuulResponse(false); //不对其进行路由
            rc.setResponseStatusCode(400);
            rc.setResponseBody("token is empty");
            rc.set("isSuccess", false);
            return null;
        }

    }
}
