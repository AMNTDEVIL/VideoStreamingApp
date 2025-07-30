package com.example.videostreamingapp.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.videostreamingapp.backend.entity.VideoEntity;
import com.example.videostreamingapp.backend.repository.VideoDescRepository;

@Service
public class VideoDescService {

    private final VideoDescRepository videoDescRepository;

    // Constructor injection - recommended
    public VideoDescService(VideoDescRepository videoDescRepository) {
        this.videoDescRepository = videoDescRepository;
    }

    public VideoEntity uploadVideo(VideoEntity videoDesc) {
        return videoDescRepository.save(videoDesc);
    }

    public Optional<VideoEntity> findByTitle(String title) {
        return videoDescRepository.findByTitle(title);
    }

    public Optional<VideoEntity> findById(Long id) {
        return videoDescRepository.findById(id);
    }

    public VideoEntity save(VideoEntity video) {
        return videoDescRepository.save(video);
    }
}
