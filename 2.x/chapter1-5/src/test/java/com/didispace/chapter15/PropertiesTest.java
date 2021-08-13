package com.didispace.chapter15;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private JasyptExample jasyptExample;

    @Test
    public void test() {
        log.info("from1 : {}", jasyptExample.getFrom1());
        log.info("from2 : {}", jasyptExample.getFrom2());
    }

}
