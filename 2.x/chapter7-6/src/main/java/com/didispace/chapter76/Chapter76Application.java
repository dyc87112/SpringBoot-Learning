package com.didispace.chapter76;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Chapter76Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter76Application.class, args);
    }

}
