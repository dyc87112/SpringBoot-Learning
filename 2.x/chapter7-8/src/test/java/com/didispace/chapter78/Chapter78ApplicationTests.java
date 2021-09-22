package com.didispace.chapter78;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
public class Chapter78ApplicationTests {

    @Autowired
    private AsyncTasks asyncTasks;

    @Test
    public void test() throws Exception {
        // 线程池配置：core-2,max-2,queue=2，可以容纳4个任务提交

        long start = System.currentTimeMillis();

        // 线程池1
        CompletableFuture<String> task1 = asyncTasks.doTaskOne("1");
        CompletableFuture<String> task2 = asyncTasks.doTaskOne("2");
        CompletableFuture<String> task3 = asyncTasks.doTaskOne("3");
        CompletableFuture<String> task4 = asyncTasks.doTaskOne("4");

        // 一起执行
        CompletableFuture.allOf(task1, task2, task3, task4).join();

        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void test2() throws Exception {
        // 线程池配置：core-2,max-2,queue=2，同时有5个任务，出现下面异常：
        // org.springframework.core.task.TaskRejectedException: Executor [java.util.concurrent.ThreadPoolExecutor@59901c4d[Running, pool size = 2,
        // active threads = 0, queued tasks = 2, completed tasks = 4]] did not accept task: java.util.concurrent.CompletableFuture$AsyncSupply@408e96d9

        long start = System.currentTimeMillis();

        // 线程池1
        CompletableFuture<String> task1 = asyncTasks.doTaskOne("1");
        CompletableFuture<String> task2 = asyncTasks.doTaskOne("2");
        CompletableFuture<String> task3 = asyncTasks.doTaskOne("3");
        CompletableFuture<String> task4 = asyncTasks.doTaskOne("4");
        CompletableFuture<String> task5 = asyncTasks.doTaskOne("5");

        // 一起执行
        CompletableFuture.allOf(task1, task2, task3, task4, task5).join();

        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
