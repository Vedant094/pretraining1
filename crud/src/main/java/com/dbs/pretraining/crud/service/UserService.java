package com.dbs.pretraining.crud.service;

import com.dbs.pretraining.crud.model.DeleteRequest;
import com.dbs.pretraining.crud.model.User;
import com.dbs.pretraining.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository urepo;
    @Autowired
    private DeleteRequestService deleteRequestService;

    //Register new user
    public User registerUser(User u){
        return urepo.save(u);
    }

    //Get all users
    public List<User> getAllUsers() {
        return urepo.findAll();
    }

    //Get user by id
    public User getUserById(Long id){
        return urepo.findById(id).orElse(null);
    }

    //Update user
    public User updateUser(Long id,User updatedUser){
        User existingUser=getUserById(id);
        if(existingUser!=null){
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            return urepo.save(existingUser);
        }
        return null;
    }

    public DeleteRequest requestAccountDeletion(Long userId){
        return deleteRequestService.createRequest(userId);
    }
}
