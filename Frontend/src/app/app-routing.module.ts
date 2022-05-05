import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComplaintsDetailsComponent } from './complaints-details/complaints-details.component';
import { ComplaintsListComponent } from './complaints-list/complaints-list.component';
import { CreateComplaintsComponent } from './create-complaints/create-complaints.component';

import { DisplayEventComponent } from './Events/display-event/display-event.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: '', component:HomeComponent },
  { path: 'complaintsList', component: ComplaintsListComponent },
  { path: 'complaint/:id', component: ComplaintsDetailsComponent },
  { path: 'createComplaints', component:CreateComplaintsComponent },
  { path: 'login', component:LoginComponent },
  { path: 'register', component:RegisterComponent },
  {path:'event',component:DisplayEventComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
