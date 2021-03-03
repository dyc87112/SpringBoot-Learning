package com.didispace.chapter61;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 */
@Data
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    private String username;
    private Integer age;

}
