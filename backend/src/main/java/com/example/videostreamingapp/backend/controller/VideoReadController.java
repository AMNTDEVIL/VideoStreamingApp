package com.example.videostreamingapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.videostreamingapp.backend.entity.VideoEntity;
import com.example.videostreamingapp.backend.repository.VideoDescRepository;

@RestController
@RequestMapping("/api/auth")
public class VideoReadController {
    @Autowired
    private VideoDescRepository videoDescRepository;
    //For all
    @GetMapping("/videos")
public ResponseEntity<List<VideoEntity>> getAllVideos() {
    List<VideoEntity> videos = videoDescRepository.findAll();
    return ResponseEntity.ok(videos);
}
    //Video by id
    @GetMapping("/videos/{id}")
    public ResponseEntity<VideoEntity> getVideoById(@PathVariable Long id){
        return videoDescRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
