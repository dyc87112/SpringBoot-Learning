package com.didispace.chapter15;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEncryptableProperties
public class Chapter15Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter15Application.class, args);
    }

    @RestController
    static class HelloController {

        @Autowired
        private JasyptExample jasyptExample;

        @GetMapping("/hello")
        public String hello() {
            return "Hello World, " + jasyptExample.getFrom2();
        }

    }

}
