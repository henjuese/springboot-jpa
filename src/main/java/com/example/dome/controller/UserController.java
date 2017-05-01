package com.example.dome.controller;

import com.example.dome.domain.User;
import com.example.dome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    @ResponseBody
    public List<User> findAll() {
        return userService.findUserAll();
    }
}
