package com.example.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.entity.UserEntity;
import com.example.security.entity.UserPricipal;
import com.example.security.repository.UserRepository;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // UserEntity userEntity = new UserEntity();
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        System.out.println("userEntity >>" + userEntity.get().toString());
        UserPricipal pricipal = new UserPricipal(userEntity.get());
        System.out.println("pricipal >>" + pricipal.toString());
        return pricipal;
    }
}
