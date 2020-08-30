package com.example.ruleengine.models;

public class Address {
    private String pincode;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pincode='" + pincode + '\'' +
                '}';
    }
}
