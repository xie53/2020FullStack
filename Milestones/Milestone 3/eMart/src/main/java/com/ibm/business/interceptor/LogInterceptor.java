package com.ibm.business.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

/**
* BFFDigital
* @author ShiYan May 24, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class LogInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LogManager.getLogger(LogInterceptor.class);
	
	private long startTimeStamp;
	private long endTimeStamp;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("### API call start: [" + request.getMethod() + "] " + request.getRequestURI());
		startTimeStamp = new Date().getTime();
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		endTimeStamp = new Date().getTime();
		long spentTime = endTimeStamp - startTimeStamp;
		logger.info("### API call end: [" + request.getMethod() + "] " + request.getRequestURI() + " [" + spentTime + "ms]");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
