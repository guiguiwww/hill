package com.hanwu.hill.filter;

import com.hanwu.hill.listener.ApiMethodSelector;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CustomFilter", urlPatterns = "/*")
public class ServletFilter implements Filter {

    private ApiMethodSelector methodSelector;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter begain -------");
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        this.methodSelector = context.getBean(ApiMethodSelector.class);


    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("do filter running --------");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destory filter finish --------");
    }

}