package com.didispace.chapter81;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @blog https://blog.didispace.com
 */
@Slf4j
@SpringBootApplication
public class Chapter81Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter81Application.class, args);

        log.error("Hello World");
        log.warn("Hello World");
        log.info("Hello World");
        log.debug("Hello World");
        log.trace("Hello World");
    }

}
