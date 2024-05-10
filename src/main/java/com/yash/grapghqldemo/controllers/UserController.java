package com.yash.grapghqldemo.controllers;

import com.yash.grapghqldemo.entities.User;
import com.yash.grapghqldemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // create user api

    @MutationMapping
    public User createUser(@Argument String name,
                                @Argument String phone,
                                @Argument String email,
                                @Argument String password
                           ){

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);

        return userService.createUser(user);
    }

    // get all users

    @QueryMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // get single user

    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }

    // update user

    @MutationMapping
    public User updateUser(@Argument int userId,@Argument String name,@Argument String phone,@Argument String email){
        return userService.updateUser(userId,name,phone,email);
    }

    // delete user

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }

}
