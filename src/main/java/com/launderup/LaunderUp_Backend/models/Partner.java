package com.launderup.LaunderUp_Backend.models;

import org.springframework.data.relational.core.mapping.Table;

@Table("Partners")
public class Partner extends User {

    public Partner() {
        this.setUserType(UserType.PARTNER);
    }

    private String shopName;
    private Address shopAddress;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }
}
