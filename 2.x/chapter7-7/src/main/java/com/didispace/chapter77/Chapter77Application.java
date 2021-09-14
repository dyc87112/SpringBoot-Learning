package com.didispace.chapter77;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@SpringBootApplication
public class Chapter76Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter76Application.class, args);
    }

    @EnableAsync
    @Configuration
    class TaskPoolConfig {

//        @Bean
//        public Executor taskExecutor2() {
//            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//            executor.setCorePoolSize(1);
//            executor.setMaxPoolSize(2);
//            executor.setQueueCapacity(50);
//            executor.setKeepAliveSeconds(60);
//            executor.setThreadNamePrefix("taskExecutor2-");
//            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//            return executor;
//        }

    }

}
