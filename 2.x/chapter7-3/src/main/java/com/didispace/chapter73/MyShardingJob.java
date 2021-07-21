package com.didispace.chapter73;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyShardingJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        // sharding-total-count=3，所以任务被分为三个分片
        switch (context.getShardingItem()) {
            case 0:
                log.info("分片1：执行任务");
                break;
            case 1:
                log.info("分片2：执行任务");
                break;
            case 2:
                log.info("分片3：执行任务");
                break;
        }
    }

}