import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyAccountComponent } from './my-account/my-account.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoadingComponent } from './loading/loading.component';

const routes: Routes = [
  { path: '', component: LoadingComponent},
  { path: 'my-account', component: MyAccountComponent},
  { path: 'dashboard', component: DashboardComponent},
  

  //   { path: 'user', component: UserComponent},  
  // { path: 'user-list', component: UserListComponent},  
  //{ path: '', redirectTo: '/dashboard', pathMatch: 'full'},  
  // { path: '**', component:FileNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
