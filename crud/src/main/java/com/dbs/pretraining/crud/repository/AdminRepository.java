package com.dbs.pretraining.crud.repository;

import com.dbs.pretraining.crud.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByUsername(String username);
}
