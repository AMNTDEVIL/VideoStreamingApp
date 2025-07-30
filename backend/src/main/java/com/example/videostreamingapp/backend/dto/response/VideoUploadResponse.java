package com.example.videostreamingapp.backend.dto.response;

public class VideoUploadResponse {
    private String message;
    private String videoTitle;

    public VideoUploadResponse(String message, String videoTitle) {
        this.message = message;
        this.videoTitle = videoTitle;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
}
