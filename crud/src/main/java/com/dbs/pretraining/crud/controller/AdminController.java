package com.dbs.pretraining.crud.controller;


import com.dbs.pretraining.crud.model.Admin;
import com.dbs.pretraining.crud.model.DeleteRequest;
import com.dbs.pretraining.crud.service.AdminService;
import com.dbs.pretraining.crud.service.DeleteRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    AdminController(AdminService adminService){
        this.adminService=adminService;

    }

    //register an admin
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    //login as admin
    @PostMapping("/login")
    public String login(@RequestBody Map<String,String> credentials){
        String username=credentials.get("username");
        String password=credentials.get("password");
        boolean isValid=adminService.login(username,password);
        return isValid?"Login Successful" : "Invalid Credentials";
    }

    //get admin by id
    @GetMapping("{id}")
    public Admin getAdminDetails(@PathVariable Long id){
        return adminService.getAdminById(id);
    }
}
