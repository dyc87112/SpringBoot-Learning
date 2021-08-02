package com.didispace.chapter63;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Chapter63Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter63Application.class, args);
	}

}
