package com.example.demo.config;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class remoteIpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("remoteIpFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String remoteAddr = request.getRemoteAddr();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("remoteIpFilter doFilter"+remoteAddr+":"+requestURL);
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("======after=====");
    }

    @Override
    public void destroy() {
        System.out.println("remoteIpFilter destroy");
    }
}
