package com.kopranych.userservice.service.impl;

import com.kopranych.userservice.model.User;
import com.kopranych.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User addNewUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
