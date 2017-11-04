package com.walker.restfulapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.walker")
@MapperScan("com.walker.*")	//扫描repository下的mapper
@SpringBootApplication
public class RestfulapiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(RestfulapiApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestfulapiApplication.class);
	}

}
