package com.didispace.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/16 下午12:58.
 * @blog http://blog.didispace.com
 */
@Slf4j
@Component
public class Task {

    public static Random random = new Random();

    @Async("taskExecutor")
    public Future<String> run() throws Exception {
        long sleep = random.nextInt(10000);
        log.info("开始任务，需耗时：" + sleep + "毫秒");
        Thread.sleep(sleep);
        log.info("完成任务");
        return new AsyncResult<>("test");
    }

}
