package com.kopranych.userservice.service.impl;

import com.kopranych.userservice.model.User;
import com.kopranych.userservice.repository.UserRepository;
import com.kopranych.userservice.service.Encryptor;
import com.kopranych.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Encryptor encryptor;
    @Override
    public User addNewUser(User user) {
        String hashPassword = encryptor.securePassword(user.getHashPassword());
        user.setHashPassword(hashPassword);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}
