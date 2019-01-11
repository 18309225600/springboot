package com.example.demo.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String name;
    private String mail;
    private String gender;

    public User() {
    }

    public User(Long id, String name, String mail, String gender) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
