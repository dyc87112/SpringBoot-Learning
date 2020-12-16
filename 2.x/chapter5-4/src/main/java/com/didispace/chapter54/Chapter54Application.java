package com.didispace.chapter54;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter54Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter54Application.class, args);
	}

}
