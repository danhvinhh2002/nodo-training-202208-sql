package edu.hanoi.service.controller;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestServiceController {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/list/users")
    public List<User> listUser(){
        return userDAO.list();
    }
}
