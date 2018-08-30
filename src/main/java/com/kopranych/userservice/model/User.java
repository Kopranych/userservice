package com.kopranych.userservice.model;


import lombok.Data;
import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastname;
    private LocalDate birthDate;
    private String userEmail;
    private String hashPassword;

}
