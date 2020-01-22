package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/3/23 下午2:34.
 * @blog http://blog.didispace.com
 */
@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
