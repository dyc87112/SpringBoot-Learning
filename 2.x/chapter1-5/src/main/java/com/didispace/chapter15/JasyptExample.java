package com.didispace.chapter15;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
public class JasyptExample {

    @Value("${com.didispace.from1:}")
    private String from1;
    @Value("${com.didispace.from2:}")
    private String from2;

}