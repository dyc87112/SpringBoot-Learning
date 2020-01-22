package com.didispace.chapter31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String name, Integer age) {
        int row = jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
        return row;
    }

    @Override
    public List<User> getByName(String name) {
        List<User> users = jdbcTemplate.query("select NAME, AGE from USER where NAME = ?", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            return user;
        }, name);
        return users;
    }

    @Override
    public int deleteByName(String name) {
        int row = jdbcTemplate.update("delete from USER where NAME = ?", name);
        return row;
    }

    @Override
    public int getAllUsers() {
        int row = jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
        return row;
    }

    @Override
    public int deleteAllUsers() {
        int row = jdbcTemplate.update("delete from USER");
        return row;
    }

}