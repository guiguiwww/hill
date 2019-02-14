package com.hanwu.hill.filter;

import com.hanwu.hill.listener.ApiMethodSelector;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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

import java.io.IOException;

import com.hanwu.hill.listener.HttpRequest;

@WebFilter(filterName = "CustomFilter", urlPatterns = "/*")
public class ServletFilter implements Filter {

	private ApiMethodSelector methodSelector;

	@Override
	public void init(FilterConfig filterConfig) {
		System.out.println("init filter begin -------");
		ServletContext servletContext = filterConfig.getServletContext();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		this.methodSelector = context.getBean(ApiMethodSelector.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("do filter running --------");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpRequest httpRequest = new HttpRequest(httpServletRequest);
		System.out.println(httpRequest.getBody());
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		chain.doFilter(httpRequest, httpResponse);
	}

	private void uploadMethod() {

	}

	@Override
	public void destroy() {

		System.out.println("destroy filter finish --------");
	}

}