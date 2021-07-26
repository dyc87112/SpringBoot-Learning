package com.didispace.chapter74;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MySimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        log.info("MySimpleJob start : didispace.com {}", System.currentTimeMillis());
        throw new RuntimeException("模拟任务出现异常");
    }

}