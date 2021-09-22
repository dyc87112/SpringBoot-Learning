package com.didispace.chapter78;

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
public class Chapter78Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter78Application.class, args);
    }

    @EnableAsync
    @Configuration
    class TaskPoolConfig {

        @Bean
        public Executor taskExecutor1() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(2);
            executor.setMaxPoolSize(2);
            executor.setQueueCapacity(2);
            executor.setKeepAliveSeconds(60);
            executor.setThreadNamePrefix("executor-1-");

            // 配置拒绝策略
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            return executor;
        }

    }

}
