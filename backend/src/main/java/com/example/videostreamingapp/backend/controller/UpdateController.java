package com.example.videostreamingapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.videostreamingapp.backend.dto.request.UpdateRequest;
import com.example.videostreamingapp.backend.dto.response.UpdateResponse;
import com.example.videostreamingapp.backend.entity.UserEntity;
import com.example.videostreamingapp.backend.service.UserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Validated
public class UpdateController {

    private final UserService userService;

    @Autowired
    public UpdateController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateResponse> updateUser(@Valid @RequestBody UpdateRequest request) {
        UserEntity updatedUser = userService.updateUser(request);
        
        UpdateResponse response = new UpdateResponse(
            "Updated Successfully", 
            updatedUser.getUserName()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Update controller is working!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UpdateResponse> handleException(Exception e) {
        UpdateResponse response = new UpdateResponse(
            "Failed to update: " + e.getMessage(),
            null
        );
        return ResponseEntity.internalServerError().body(response);
    }
}