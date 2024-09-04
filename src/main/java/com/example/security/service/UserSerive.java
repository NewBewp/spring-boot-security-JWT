package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.repository.UserRepository;

@Service
public class UserSerive {

    @Autowired
    private UserRepository userRepository;

    
}
