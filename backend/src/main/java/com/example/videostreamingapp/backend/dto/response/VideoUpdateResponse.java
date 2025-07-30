package com.example.videostreamingapp.backend.dto.response;

public class VideoUpdateResponse {
    private String message;

    private String oldTitle;
    private String newTitle;

    private String oldDescription;
    private String newDescription;

    private String oldThumbnailUrl;
    private String newThumbnailUrl;

    public VideoUpdateResponse(String message,
                               String oldTitle, String newTitle,
                               String oldDescription, String newDescription,
                               String oldThumbnailUrl, String newThumbnailUrl) {
        this.message = message;
        this.oldTitle = oldTitle;
        this.newTitle = newTitle;
        this.oldDescription = oldDescription;
        this.newDescription = newDescription;
        this.oldThumbnailUrl = oldThumbnailUrl;
        this.newThumbnailUrl = newThumbnailUrl;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getOldTitle() {
        return oldTitle;
    }
    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    public String getNewTitle() {
        return newTitle;
    }
    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getOldDescription() {
        return oldDescription;
    }
    public void setOldDescription(String oldDescription) {
        this.oldDescription = oldDescription;
    }

    public String getNewDescription() {
        return newDescription;
    }
    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getOldThumbnailUrl() {
        return oldThumbnailUrl;
    }
    public void setOldThumbnailUrl(String oldThumbnailUrl) {
        this.oldThumbnailUrl = oldThumbnailUrl;
    }

    public String getNewThumbnailUrl() {
        return newThumbnailUrl;
    }
    public void setNewThumbnailUrl(String newThumbnailUrl) {
        this.newThumbnailUrl = newThumbnailUrl;
    }
}
