package com.example.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authManager;

    public String verify(String username, String password) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        if( !auth.isAuthenticated() ){
            throw new Error("dang nhap sai");
        }

        return "test >>>> ";
    }
}
