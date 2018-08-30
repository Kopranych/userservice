package com.kopranych.userservice.service;

import com.kopranych.userservice.model.User;

public interface UserService {
    User addNewUser(User user);
    void deleteUser(Long userId);
    User getUserByEmail(String email);
}
