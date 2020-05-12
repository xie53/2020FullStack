package com.ibm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.business.filter.AuthenticationFilter;
import com.ibm.business.filter.BaseFilter;
import com.ibm.business.message.MessageProperties;
import com.ibm.business.service.AuthenticationService;

@Configuration
public class FilterConfig {

    @Autowired
    AuthenticationFilter authenticationFilter;

    @Bean
    @Autowired
    public AuthenticationFilter authenticationFilter(
            AuthenticationService authenticationService, MessageProperties messageProperties,
            @Value("${swagger.enabled}") String isSwaggerEnabled) {
        return new AuthenticationFilter(authenticationService, messageProperties,
                isSwaggerEnabled.equals("true"));
    }

    @Bean
    @Autowired
    public FilterRegistrationBean<BaseFilter> filterRegistrationBean() {
        FilterRegistrationBean<BaseFilter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(authenticationFilter);
        filterBean.setOrder(0);
        return filterBean;
    }
}
