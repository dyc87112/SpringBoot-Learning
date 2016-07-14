package com.didispace;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@ImportResource({"classpath:dubbo.xml"})
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class);

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		logger.info("项目启动!");
		CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
		closeLatch.await();
	}

}
