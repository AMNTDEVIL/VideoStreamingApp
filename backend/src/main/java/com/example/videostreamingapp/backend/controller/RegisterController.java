package com.example.videostreamingapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.videostreamingapp.backend.dto.request.RegisterRequest;
import com.example.videostreamingapp.backend.dto.response.RegisterResponse;
import com.example.videostreamingapp.backend.entity.UserEntity;
import com.example.videostreamingapp.backend.service.UserService;

@RestController
@RequestMapping("/api/auth") 
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest request) {
        UserEntity user=new UserEntity();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setGender(request.getGender());
        user.setLastName(request.getLastName()); 
        user.setPassword(request.getPassword());
        user.setConfirmPassword(request.getConfirmPassword());
        UserEntity savedUser= userService.registerUser(user);

        RegisterResponse response = new RegisterResponse(
            "User registered successfully", 
            savedUser.getUserName()
        );

        return ResponseEntity.ok(response);
    }
}
