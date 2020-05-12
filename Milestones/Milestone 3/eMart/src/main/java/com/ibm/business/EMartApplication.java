package com.ibm.business;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class EMartApplication extends SpringBootServletInitializer {

	private static final Logger logger = LogManager.getLogger(EMartApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Service!");
		
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
		
		SpringApplication.run(EMartApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EMartApplication.class);
	}
}
