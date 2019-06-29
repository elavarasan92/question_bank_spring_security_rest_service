package com.questionbank.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket api() {
		// Adding Header
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization") // name of header
				.description("Have to convert the username and password to base64 encoded text and give the value in below box")
				.modelRef(new ModelRef("string")).parameterType("header") // type - header
				.defaultValue("Basic cmFtZXNoZWxhdmFAZ21haWwuY29tOmVsYXZhcmFzYW5A") // based64 of - rameshelava@gmail.com:elavarasan@
				.required(true) // for compulsory
				.build();
		List<springfox.documentation.service.Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder.build()); // add parameter
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("").globalOperationParameters(aParameters);
	}
}