package com.example.videostreamingapp.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.videostreamingapp.backend.dto.request.LoginRequest;
import com.example.videostreamingapp.backend.dto.response.LoginResponse;
import com.example.videostreamingapp.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
class LoginController{
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request){
        return userService.login(request.getEmail(), request.getPassword()).map(user->ResponseEntity.ok(
            new LoginResponse("Login Successful", user.getUserName())
        )).orElseGet(()->ResponseEntity.status(401).body(new LoginResponse("Invalid email or password",null)));
    }
}