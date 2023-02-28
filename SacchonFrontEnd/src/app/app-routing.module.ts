import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultationsListComponent } from './consultations-list/consultations-list.component';
import { MyAccountComponent } from './my-account/my-account.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: 'my-account', component: MyAccountComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'consultations-list', component: ConsultationsListComponent},
  //   { path: 'user', component: UserComponent}, 
  // { path: 'user-list', component: UserListComponent}, 
  { path: '', redirectTo: '/dashboard', pathMatch: 'full'}, 
  { path: '', component: DashboardComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
