package com.example.videostreamingapp.backend.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateRequest {
    @NotBlank(message="User name is required")
    private String userName;
    @Email(message="Invalid Format")
    @NotBlank(message="Email is required")
    private String email;
    @NotBlank(message="Password is required")
    @Size(min=6,message="Password must be minimum 6 letters")
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dob;
    private Integer number;
    private String profilePicture;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getNumber(){
        return number;
    }
    public void setNumber(Integer number){
        this.number=number;
    }
    public Date getDate(){
        return dob;
    }
    public void setDate(Date dob){
        this.dob=dob;
    }
    public String getProfilePicture(){
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture){
        this.profilePicture=profilePicture;
    }
}