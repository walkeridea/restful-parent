package com.walker.restfulapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(1)
@Configuration
public class StartupRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);
	@Override
	public void run(String... args) throws Exception {

		//加载配置
		logger.info("startup runner");
	}

}
