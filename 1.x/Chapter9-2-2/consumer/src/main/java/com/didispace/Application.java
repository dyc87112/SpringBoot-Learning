package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo.xml"})
public class Application {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}

}
