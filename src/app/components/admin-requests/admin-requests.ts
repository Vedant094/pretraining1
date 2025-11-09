import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-admin-requests',
  imports: [CommonModule],
  templateUrl: './admin-requests.html',
  styleUrl: './admin-requests.css',
})
export class AdminRequests implements OnInit {
  pendingRequests:any[]=[];
  message:string='';

  constructor(private adminService:AdminService){}

  ngOnInit():void{
    this.loadPendingRequests();
  }

  loadPendingRequests(){
    this.adminService.getPendingRequests().subscribe({
      next:(data)=>{
        this.pendingRequests=data;
      },
      error:(err)=>{
        this.message='Error loading pending requests.';
      }
    });
  }

  approveRequest(id:number){
    this.adminService.approveRequest(id).subscribe({
      next:()=>{
        this.message=`Request ${id} approved. User deleted.`;
        this.loadPendingRequests();
      },
      error:()=>{
        this.message=`Error approving request ${id}`;
      }
    });
  }

  declineRequest(id:number){
    this.adminService.declineRequest(id).subscribe({
      next:()=>{
        this.message=`Request ${id} declined.`;
        this.loadPendingRequests();
      },
      error:()=>{
        this.message=`Error declining request ${id}.`
      }
    });
  }
}
