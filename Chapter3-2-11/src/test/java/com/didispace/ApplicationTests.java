package com.didispace;

import com.mongodb.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Autowired
    private MongoClient mongoClient;

    @Test
    public void test() throws Exception {
        log.info("MinConnectionsPerHost = {}, MaxConnectionsPerHost = {}",
                mongoClient.getMongoClientOptions().getMinConnectionsPerHost(),
                mongoClient.getMongoClientOptions().getConnectionsPerHost());
    }

}
