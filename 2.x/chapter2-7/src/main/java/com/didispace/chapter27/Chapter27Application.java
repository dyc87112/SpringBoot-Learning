package com.didispace.chapter27;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class Chapter27Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter27Application.class, args);
    }

}
