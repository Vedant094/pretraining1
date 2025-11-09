import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { response } from 'express';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-user-auth',
  imports: [FormsModule],
  templateUrl: './user-auth.html',
  styleUrl: './user-auth.css',
})
export class UserAuth {
  user={
    username:'',
    email:'',
    password:''
  };

  message:string='';

  constructor(private userService:UserService){}

  register(){
    this.userService.register(this.user).subscribe({
      next:(response)=>{
        this.message="User Registered Successfully";
      },
      error:()=>{
        this.message="Registration Failed";
      }
    });
  }
}
