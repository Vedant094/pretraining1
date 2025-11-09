import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})

export class AdminService{
    private apiUrl=environment.apiUrl;
    constructor(private http:HttpClient){}

    //Get all pending requests
    getPendingRequests():Observable<any[]>{
        return this.http.get<any[]>(`${this.apiUrl}/delete-request/pending`);
    }

    //Approve a delete request
    approveRequest(id:number):Observable<any>{
        return this.http.put(`${this.apiUrl}/delete-request/approve/${id}`,{});
    }

    //Decline a delete request
    declineRequest(id:number):Observable<any>{
        return this.http.put(`${this.apiUrl}/delete-request/decline/${id}`,{});
    }

}