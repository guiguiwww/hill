package com.hanwu.hill.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ServletFilter.class);

	// TODO private ApiMethodSelector methodSelector;

	@Override
	public void init(FilterConfig filterConfig) {
		logger.info("init filter begin -------");
		ServletContext servletContext = filterConfig.getServletContext();
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		// TODO this.methodSelector = context.getBean(ApiMethodSelector.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.info("do filter running --------");
		// TODO methodSelector;

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpRequest httpRequest = new HttpRequest(httpServletRequest);
		logger.info(httpRequest.getBody());
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		chain.doFilter(httpRequest, httpResponse);
	}

	private void uploadMethod() {

	}

	@Override
	public void destroy() {

		logger.info("destroy filter finish --------");
	}

}