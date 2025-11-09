package com.dbs.pretraining.crud.repository;

import com.dbs.pretraining.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
