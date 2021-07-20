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
        switch (context.getShardingItem()) {
            case 0:
                log.info("do something by sharding item 0");
                break;
            case 1:
                log.info("do something by sharding item 1");
                break;
            case 2:
                log.info("do something by sharding item 2");
                break;
        }
    }

}