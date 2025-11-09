package com.dbs.pretraining.crud.repository;

import com.dbs.pretraining.crud.model.DeleteRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeleteRequestRepository extends JpaRepository<DeleteRequest,Long> {
    List<DeleteRequest> findByStatus(String Status);
}
