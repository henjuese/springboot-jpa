package com.example.dome.service;

import com.example.dome.dao.UserRepository;
import com.example.dome.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUserAll(){
        return (List<User>)userRepository.findAll();
    }
}
