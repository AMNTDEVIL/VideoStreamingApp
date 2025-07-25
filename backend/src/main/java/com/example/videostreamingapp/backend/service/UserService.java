package com.example.videostreamingapp.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videostreamingapp.backend.entity.UserEntity;
import com.example.videostreamingapp.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserEntity registerUser(UserEntity user){
        Optional<UserEntity> existingUser=userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            throw  new RuntimeException("Email ALready Registered");
        }
        return userRepository.save(user);
    }
    public Optional<UserEntity> login(String email,String password){
        return userRepository.findByEmail(email).filter(user-> user.getPassword().equals(password));

    }
}
