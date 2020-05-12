package com.ibm.business;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ibm.business.constant.SwaggerConstant;
import com.ibm.business.interceptor.LogInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").excludePathPatterns(SwaggerConstant.SWAGGER_PATHS);
	}
}
