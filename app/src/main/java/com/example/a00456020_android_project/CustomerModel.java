package com.example.a00456020_android_project;

public class CustomerModel {
    /*
    {
        "id": 1,
        "name": "Parth",
        "mobile": "9024567898",
        "email": "vdpar9556@ymail.com"
    }
    */
    String id;
    String name;
    String email;
    String mobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
