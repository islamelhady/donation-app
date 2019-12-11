package com.elhady.donation.model;

/**
 * Created by El-hady on 4/21/2018.
 */
public class User {
    private String email;
    private String name;
    private String password;

    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Pemail) {
        this.email = Pemail;
    }

    public String getName() {
        return name;
    }

    public void setName(String Pname) {
        this.name = Pname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Ppassword) {
        this.password = Ppassword;
    }
}