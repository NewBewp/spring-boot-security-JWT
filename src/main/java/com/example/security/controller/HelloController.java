package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloString() {
        return "hello world";
    }

    @GetMapping("/hello1")
    public String helloString1() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("auth >>>> " + auth);

        return "hello world 1";
    }

}
