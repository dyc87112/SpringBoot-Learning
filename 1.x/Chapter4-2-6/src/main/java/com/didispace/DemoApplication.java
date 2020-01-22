package com.didispace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testLogLevel() {
		logger.debug("Logger Level ：DEBUG");
		logger.info("Logger Level ：INFO");
		logger.error("Logger Level ：ERROR");
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
