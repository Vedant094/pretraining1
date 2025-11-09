package com.dbs.pretraining.crud.controller;

import com.dbs.pretraining.crud.model.DeleteRequest;
import com.dbs.pretraining.crud.service.DeleteRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delete-request")
public class DeleteRequestController {

    private final DeleteRequestService deleteRequestService;

    public DeleteRequestController(DeleteRequestService deleteRequestService){
        this.deleteRequestService=deleteRequestService;
    }

    @GetMapping("/pending")
    public List<DeleteRequest> pending(){
        return deleteRequestService.getPendingRequests();
    }

    @PutMapping("/approve/{id}")
    public DeleteRequest approve(@PathVariable Long id){
        return deleteRequestService.approveRequest(id);
    }

    @PutMapping("/decline/{id}")
    public DeleteRequest decline(@PathVariable Long id){
        return deleteRequestService.declineRequest(id);
    }
}
