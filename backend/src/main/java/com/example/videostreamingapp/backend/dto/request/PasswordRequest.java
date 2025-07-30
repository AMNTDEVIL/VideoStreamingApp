package com.example.videostreamingapp.backend.dto.request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Size;

public class PasswordRequest {
    @NonNull
    private String userName;
    @Size(min=6,message="Size must be more than 6")
    private String lastPassword;
    private String password;
    private String confirmPassword;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getLastPassword(){
        return lastPassword;
    }
    public void setLastPassword(String lastPassword){
        this.lastPassword=lastPassword;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getConfirmPassword(){
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword=confirmPassword;
    }
   
}
