package com.kopranych.userservice.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "BIRTHDATE")
    private LocalDate birthDate;
    @Column(name = "EMAIL")
    private String userEmail;
    @Column(name = "PASSWORD")
    private String hashPassword;

    public User(String firstName, String lastName, LocalDate birthDate, String userEmail, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.userEmail = userEmail;
        //TODO добавить функцию хэширования пароля
        this.hashPassword = password;
    }
}
