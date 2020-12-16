package com.didispace.chapter310;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Chapter310Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter310Application.class, args);
	}

	@RestController
	static class TextController {

		@GetMapping("/hello")
		public String hello() {
			return "hello world";
		}

	}

}
