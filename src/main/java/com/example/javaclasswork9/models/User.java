package com.example.javaclasswork9.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor

@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String mail;
    private String password;
    private String avatar;

    public User(int id) {
        this.id = id;
    }

    public User(String firstname, String lastname, int age, String mail, String password, String avatar) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.mail = mail;
        this.password = password;
        this.avatar = avatar;
    }
}














