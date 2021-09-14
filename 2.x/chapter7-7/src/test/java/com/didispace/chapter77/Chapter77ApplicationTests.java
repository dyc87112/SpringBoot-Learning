package com.didispace.chapter76;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
public class Chapter76ApplicationTests {

    @Autowired
    private AsyncTasks asyncTasks;

    @Test
    public void test1() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> task1 = asyncTasks.doTaskOne();
        CompletableFuture<String> task2 = asyncTasks.doTaskTwo();
        CompletableFuture<String> task3 = asyncTasks.doTaskThree();

        CompletableFuture.allOf(task1, task2, task3).join();

        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void test2() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> task1 = asyncTasks.doTaskFour();
        CompletableFuture<String> task2 = asyncTasks.doTaskFour();
        CompletableFuture<String> task3 = asyncTasks.doTaskFour();

        CompletableFuture.allOf(task1, task2, task3).join();

        long end = System.currentTimeMillis();

        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
