package com.yash.grapghqldemo.services;

import com.yash.grapghqldemo.entities.User;
import com.yash.grapghqldemo.helper.ExceptionHandler;
import com.yash.grapghqldemo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // creating user
    public User createUser(User user){
        return userRepo.save(user);
    }

    // getting all users
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    // getting single user
    public User getUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException );
        return user;
    }

    // updating user

    public User updateUser(int userId,String name, String phone, String email){
        User existingUser  = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException);

        if (name != null && !name.isEmpty()) {
            existingUser .setName(name);
        }
        if (phone != null && !phone.isEmpty()) {
            existingUser .setPhone(phone);
        }
        if (email != null && !email.isEmpty()) {
            existingUser.setEmail(email);
        }

        // Update other fields as needed

        return userRepo.save(existingUser);
    }

    // deleting user
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHandler::throwResourceNotFoundException );
        userRepo.delete(user);
        return true;
    }

}
