package com.launderup.LaunderUp_Backend.dtos;

import jakarta.validation.constraints.NotNull;

public class LoginRequestDTO {
    private String phoneNumber;
    private String password;

    // Getters and setters
    @NotNull(message = "Phone number is required")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NotNull(message = "Password is required")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}