package com.kailera.isolated.controllers;


import com.kailera.isolated.DTOs.MessageResponseDTO;
import com.kailera.isolated.entities.User;
import com.kailera.isolated.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public MessageResponseDTO create(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

}
