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
import java.util.concurrent.RejectedExecutionHandler;
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

            /**配置拒绝策略**/

            // AbortPolicy策略：默认策略，如果线程池队列满了丢掉这个任务并且抛出RejectedExecutionException异常。
//            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

            // DiscardPolicy策略：如果线程池队列满了，会直接丢掉这个任务并且不会有任何异常。
//            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

            // DiscardOldestPolicy策略：如果队列满了，会将最早进入队列的任务删掉腾出空间，再尝试加入队列。
//            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());

            // CallerRunsPolicy策略：如果添加到线程池失败，那么主线程会自己去执行该任务，不会等待线程池中的线程去执行。
//            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

            // 自定义策略
//            executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
//                @Override
//                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//
//                }
//            });

            return executor;
        }

    }

}
