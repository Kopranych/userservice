package com.kopranych.userservice.controller;

import com.kopranych.userservice.model.User;
import com.kopranych.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public @ResponseBody User addUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get/{email}")
    public @ResponseBody User getUser(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
