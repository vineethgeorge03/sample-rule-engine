package com.example.ruleengine.models;

import java.util.List;

public class Applicant {
    private Integer age;
    private List<Address> addressList;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "age=" + age +
                ", addressList=" + addressList +
                '}';
    }
}
