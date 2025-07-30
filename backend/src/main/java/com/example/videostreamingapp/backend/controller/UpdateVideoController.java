package com.example.videostreamingapp.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.videostreamingapp.backend.dto.request.UpdateVideoRequest;
import com.example.videostreamingapp.backend.dto.response.VideoUpdateResponse;
import com.example.videostreamingapp.backend.entity.VideoEntity;
import com.example.videostreamingapp.backend.service.VideoDescService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UpdateVideoController {

    private final VideoDescService videoDescService;

    @Autowired
    public UpdateVideoController(VideoDescService videoDescService){
        this.videoDescService = videoDescService;
    }

    @PutMapping("/updatevideo/{id}")
    public ResponseEntity<VideoUpdateResponse> updateVideo(
        @PathVariable Long id,
        @Valid @RequestBody UpdateVideoRequest request) {

        Optional<VideoEntity> optionalVideo = videoDescService.findById(id);

        if (!optionalVideo.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        VideoEntity video = optionalVideo.get();

        // Save old values
        String oldTitle = video.getTitle();
        String oldDescription = video.getDescription();
        String oldThumbnailUrl = video.getThumbnailUrl();

        // Update with new values
        video.setTitle(request.getTitle());
        video.setDescription(request.getDescription());
        video.setDurationInSeconds(request.getDurationInSeconds());
        video.setVideoUrl(request.getVideoUrl());
        video.setThumbnailUrl(request.getThumbnailUrl());
        video.setUploadDate(request.getUploadDate());

        videoDescService.save(video);

        // Compose a message showing changes for title, description, and thumbnail URL
        String message = String.format(
            "Video updated successfully. Title: '%s' → '%s', Description: '%s' → '%s', Thumbnail URL: '%s' → '%s'.",
            oldTitle, video.getTitle(),
            oldDescription, video.getDescription(),
            oldThumbnailUrl, video.getThumbnailUrl()
        );

        VideoUpdateResponse response = new VideoUpdateResponse(
    "Video updated successfully.",
    oldTitle, video.getTitle(),
    oldDescription, video.getDescription(),
    oldThumbnailUrl, video.getThumbnailUrl()
);
        return ResponseEntity.ok(response);
    }
}
