package com.didispace.chapter75;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Chapter75Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter75Application.class, args);
    }

}
