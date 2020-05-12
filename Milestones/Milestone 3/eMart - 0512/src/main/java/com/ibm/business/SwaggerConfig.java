package com.ibm.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.scan.path}")
	private String swaggerScanPath;
	
	@Value("${swagger.display.title}")
	private String displayTitle;
	
	@Value("${swagger.display.version}")
	private String displayVersion;
	
	@Value("${swagger.display.description}")
	private String displayDescription;
	
	@Bean
	public Docket documentation(@Value("${swagger.enabled}") String isSwaggerEnabled) {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.apiInfo(metadata())
				.enable(isSwaggerEnabled.equals("true"))
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.basePackage(swaggerScanPath))
				.build();
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title(displayTitle)
				.version(displayVersion)
				.description(displayDescription)
				.build();
	}
}
