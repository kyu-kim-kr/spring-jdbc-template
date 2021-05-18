package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDao.class);
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> findAll() {
        String query = "select * from user";
        List<User> users = this.jdbcTemplate.query(query, new UserMapper());
        return users;
    }
    public User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        UserMapper userMapper = new UserMapper();

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, userMapper);
    }
}
