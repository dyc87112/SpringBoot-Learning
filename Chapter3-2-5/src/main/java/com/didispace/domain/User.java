package com.didispace.domain;

import java.io.Serializable;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/4/15 下午1:58.
 * @blog http://blog.didispace.com
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
