import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { UserAuth } from './components/user-auth/user-auth';
import { RequestDelete } from './components/request-delete/request-delete';
import { AdminRequests } from './components/admin-requests/admin-requests';

export const routes: Routes = [
    {path:'',redirectTo:'/register',pathMatch:'full'},
    {path:'register',component:UserAuth},
    {path:'request-delete', component:RequestDelete},
    {path:'admin', component:AdminRequests}
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})

export class AppRoutingModule{}
