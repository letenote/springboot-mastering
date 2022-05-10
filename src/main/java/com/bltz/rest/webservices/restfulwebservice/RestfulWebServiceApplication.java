package com.bltz.rest.webservices.restfulwebservice;

import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.exception.CustomizedResponseLayerExceptionResolverHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class RestfulWebServiceApplication implements WebMvcConfigurer {
//	@Override
//	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//		resolvers.add(0, new CustomizedResponseLayerExceptionResolverHandler());
//	}

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServiceApplication.class, args);
	}

}
