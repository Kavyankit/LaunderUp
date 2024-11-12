package com.launderup.LaunderUp_Backend.models;

import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

@Table("Customers")
public class Customer extends User {

    public Customer() {
        this.setUserType(UserType.CUSTOMER);
    }

    private String firstname;
    private String lastname;
    private String email;
    private final ArrayList<Address> addresses = new ArrayList<>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
