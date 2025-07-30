package com.example.videostreamingapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.videostreamingapp.backend.dto.request.PasswordRequest;
import com.example.videostreamingapp.backend.dto.response.UpdateResponse;
import com.example.videostreamingapp.backend.entity.UserEntity;
import com.example.videostreamingapp.backend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Validated
public class PasswordController {

    private final UserService userService;

    @Autowired
    public PasswordController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/updatePass")
    public ResponseEntity<UpdateResponse> updatePassword(@Valid @RequestBody PasswordRequest request) {
        UserEntity updatedUser = userService.updatePassword(request);

        UpdateResponse response = new UpdateResponse(
            "Password Updated Successfully",
            updatedUser.getUserName()  
        );
        return ResponseEntity.ok(response);
    }
    @GetMapping("/testing")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Password controller is working!");
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
