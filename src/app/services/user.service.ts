import { Injectable, ɵisEnvironmentProviders } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class UserService{
    private apiUrl=environment.apiUrl;

    constructor(private http:HttpClient){}

    //Register
    register(user:any):Observable<any>{
        return this.http.post(`${this.apiUrl}/register`,user);
    }

    //Get user by id
    getUserById(id:number):Observable<any>{
        return this.http.get(`${this.apiUrl}/${id}`);
    }

    //Request Account Deletion
    requestDeletion(userId:number):Observable<any>{
        return this.http.delete(`${this.apiUrl}/request-delete/${userId}`, {responseType:'text'})
    }
}