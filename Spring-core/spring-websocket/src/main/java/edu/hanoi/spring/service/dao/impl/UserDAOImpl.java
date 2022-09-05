package edu.hanoi.spring.service.dao.impl;

import edu.hanoi.spring.model.User;
import edu.hanoi.spring.service.dao.UserDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    JdbcTemplate jdbcTemplate;
    @Override
    public String insert(User user) {
        return null;
    }

    @Override
    public void delete(String user) {

    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User get(String username) {
        return null;
    }

    @Override
    public void update(User user) {

    }
}
