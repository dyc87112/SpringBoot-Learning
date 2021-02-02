package com.didispace.chapter312;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    private JdbcTemplate primaryJdbcTemplate;
    private JdbcTemplate secondaryJdbcTemplate;

    public TestService(JdbcTemplate primaryJdbcTemplate, JdbcTemplate secondaryJdbcTemplate) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
        this.secondaryJdbcTemplate = secondaryJdbcTemplate;
    }

    @Transactional
    public void tx() {
        // 修改test1库中的数据
        primaryJdbcTemplate.update("update user set age = ? where name = ?", 30, "aaa");
        // 修改test2库中的数据
        secondaryJdbcTemplate.update("update user set age = ? where name = ?", 30, "aaa");
    }

    @Transactional
    public void tx2() {
        // 修改test1库中的数据
        primaryJdbcTemplate.update("update user set age = ? where name = ?", 40, "aaa");
        // 模拟：修改test2库之前抛出异常
        throw new RuntimeException();
    }

}
