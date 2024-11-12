package com.launderup.LaunderUp_Backend.models;

import org.springframework.data.relational.core.mapping.Table;

import java.util.*;

@Table("Customers")
public class Customer extends User {

    public Customer() {
        this.setUserType(UserType.CUSTOMER);
    }

    private String name;
    private String email;
    private final ArrayList<Address> addresses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
