package com.dbs.pretraining.crud.service;

import com.dbs.pretraining.crud.model.DeleteRequest;
import com.dbs.pretraining.crud.model.User;
import com.dbs.pretraining.crud.repository.DeleteRequestRepository;
import com.dbs.pretraining.crud.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteRequestService {

    private final DeleteRequestRepository deleteRequestRepository;
    private final UserRepository userRepository;

    public DeleteRequestService(DeleteRequestRepository deleteRequestRepository,UserRepository userRepository){
        this.deleteRequestRepository=deleteRequestRepository;
        this.userRepository=userRepository;
    }

    //Auto create Delete Request
    public DeleteRequest createRequest(Long userId){
        User user=userRepository.findById(userId).orElse(null);
        if(user==null)return null;

        DeleteRequest request=new DeleteRequest();
        request.setUser(user);
        request.setStatus("PENDING");

        return deleteRequestRepository.save(request);
    }

    //Approve:Delete user
    public DeleteRequest approveRequest(Long requestId){
        DeleteRequest request=deleteRequestRepository.findById(requestId).orElse(null);
        if(request!=null){
            request.setStatus("APPROVED");
            deleteRequestRepository.save(request);
            userRepository.delete(request.getUser());
        }
        return request;
    }

    //Decline:Keep user
    public DeleteRequest declineRequest(Long requestId){
        DeleteRequest request=deleteRequestRepository.findById(requestId).orElse(null);
        if(request!=null){
            request.setStatus("DECLINED");
            deleteRequestRepository.save(request);
        }
        return request;
    }

    //Get all Pending Requests
    public List<DeleteRequest> getPendingRequests(){
        return deleteRequestRepository.findByStatus("PENDING");
    }

}
