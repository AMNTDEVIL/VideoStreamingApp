package com.example.videostreamingapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.videostreamingapp.backend.dto.request.VideoUploadRequest;
import com.example.videostreamingapp.backend.dto.response.VideoUploadResponse;
import com.example.videostreamingapp.backend.entity.VideoEntity;
import com.example.videostreamingapp.backend.service.VideoDescService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class VideoUploadController {

    @Autowired
    private VideoDescService videoDescService;

    @PostMapping("/uploadvideo")
    public ResponseEntity<VideoUploadResponse> uploadVideo(@Valid @RequestBody VideoUploadRequest request) {
        VideoEntity videoDesc = new VideoEntity();
        videoDesc.setTitle(request.getTitle());
        videoDesc.setDescription(request.getDescription());
        videoDesc.setDurationInSeconds(request.getDurationInSeconds());
        videoDesc.setThumbnailUrl(request.getThumbnailUrl());
        videoDesc.setUploadDate(request.getUploadDate());
        videoDesc.setVideoUrl(request.getVideoUrl());

        VideoEntity savedVideo = videoDescService.uploadVideo(videoDesc);

        VideoUploadResponse response = new VideoUploadResponse("Video uploaded successfully", savedVideo.getTitle());
        return ResponseEntity.ok(response);
    }
}
