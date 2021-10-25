package com.esprit.gateway.filters;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {
	
	private final static Logger LOGGER = Logger.getLogger(PreFilter.class.getName());
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		LOGGER.info("Using Pre filter    Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

		

		return null;
	}

}