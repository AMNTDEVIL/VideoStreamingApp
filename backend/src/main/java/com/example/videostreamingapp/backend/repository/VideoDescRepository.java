package com.example.videostreamingapp.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.videostreamingapp.backend.entity.VideoEntity;

@Repository
public interface VideoDescRepository extends JpaRepository<VideoEntity, Long>{
    Optional<VideoEntity> findByTitle(String title);
    
}
