package com.example.SplitWise.controller;


import com.example.SplitWise.model.User;
import com.example.SplitWise.service.UserManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class UserController {

    @Autowired
    private UserManager userManager;


    @RequestMapping(value = "/register/user",method = RequestMethod.POST)
    public ResponseEntity registerUser(@NonNull final String userId, @NonNull final String userName)
    {
        userManager.craeteUser(userId,userName);
        return ResponseEntity.ok("");
    }   @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(@NonNull final String userId)
    {
        return userManager.getUser(userId);

    } @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public List<User> getAllUser()
    {
       return userManager.getAlluser();

    }
}
