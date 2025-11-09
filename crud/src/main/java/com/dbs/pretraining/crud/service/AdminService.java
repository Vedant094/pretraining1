package com.dbs.pretraining.crud.service;

import com.dbs.pretraining.crud.model.Admin;
import com.dbs.pretraining.crud.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    AdminService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    //Register a new Admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    //Login check
    public boolean login(String username,String password){
        Admin admin=adminRepository.findByUsername(username);
        return admin!=null && admin.getPassword().equals(password);
    }

    //Admin Details
    public Admin getAdminById(Long id){
    return adminRepository.findById(id).orElse(null);
    }
}
