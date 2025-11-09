import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../services/user';
import { response } from 'express';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-request-delete',
  imports: [FormsModule],
  templateUrl: './request-delete.html',
  styleUrl: './request-delete.css',
})
export class RequestDelete {
  userId:number=0;
  message:string='';

  constructor(private userService:UserService){}

  requestDeletion(){
    if(this.userId<=0){
      this.message='Please enter a valid user ID:';
      return;
    }
    this.userService.requestDeletion(this.userId).subscribe({
      next:(response)=>{
        this.message=response;
      },
      error:(err)=>{
        this.message='Error sending deletion request';
      }
    });
  }
}
