package com.launderup.LaunderUp_Backend.models;

public class Address {
    private String street;
    private String locality;
    private String city;
    private String state;
    private String pinCode;
    private String label; // e.g., "Home", "Work"
    private boolean isDefault;

    public Address(String street, String locality, String city, String state, String pinCode, String label, boolean isDefault) {
        this.street = street;
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.label = label;
        this.isDefault = isDefault;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
