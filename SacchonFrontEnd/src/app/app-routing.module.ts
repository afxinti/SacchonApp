import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MyAccountComponent } from './my-account/my-account.component';

const routes: Routes = [
  { path: 'my-account', component: MyAccountComponent}
  // { path: 'create', component: CreateComponent}
  //   { path: 'user', component: UserComponent},  
  // { path: 'user-list', component: UserListComponent},  
  // { path: '', redirectTo: '/home', pathMatch: 'full'},  
  // { path: '', component: HomeComponent},  
  // { path: '**', component:FileNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
