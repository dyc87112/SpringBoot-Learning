package com.didispace.chapter52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter52Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter52Application.class, args);
	}

}
