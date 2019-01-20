package com.hanwu.hill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hanwu.hill.listener.ApiMethodSelector;

@WebFilter(filterName="CustomFilter",urlPatterns="/*")
public class InitFilter implements Filter{
    
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