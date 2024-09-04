package com.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.entity.UserEntity;
import com.example.security.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String loginAuth(@RequestBody UserEntity userEntity){
        System.out.println(userEntity.getUsername() + userEntity.getPassword());
        return authService.verify(userEntity.getUsername(), userEntity.getPassword());
    }
}
