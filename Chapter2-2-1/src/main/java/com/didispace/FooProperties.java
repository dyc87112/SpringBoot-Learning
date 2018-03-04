package com.didispace;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.didispace")
public class FooProperties {

    private String foo;

    private String databasePlatform;

}