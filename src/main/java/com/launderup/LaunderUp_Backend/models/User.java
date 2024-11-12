package com.launderup.LaunderUp_Backend.models;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("Users")
public class User {

    @Id
    private Long id;

    @NotNull(message = "Phone number is required")
    @Column("phone_number") // Maps to phone_number column in the users table
    private String phoneNumber;

    @NotNull(message = "Pin code is required")
    @Column("pin_code") // Maps to pin_code column in the users table
    private String pinCode;

    @CreatedDate
    @Column("created_on") // Maps to created_on column in the users table
    private LocalDateTime createdOn;

    @Column("user_type") // Maps to user_type column in the users table
    private UserType userType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
