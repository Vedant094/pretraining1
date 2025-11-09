package com.dbs.pretraining.crud.controller;

import com.dbs.pretraining.crud.model.User;
import com.dbs.pretraining.crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
public class UserController {
    @Autowired
    private UserService uservice;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return uservice.registerUser(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return uservice.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return uservice.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id,@RequestBody User user){
        return uservice.updateUser(id,user);
    }

    @DeleteMapping("/request-delete/{userId}")
    public String requestDeletion(@PathVariable Long userId){
        uservice.requestAccountDeletion(userId);
        return "Delete Request has been sent to admin.";
    }





}
