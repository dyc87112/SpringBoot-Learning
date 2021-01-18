package com.didispace.chapter14;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.didispace")
public class DidiProperties {

    /**
     * 这是一个测试配置
     */
    private String from;

}
