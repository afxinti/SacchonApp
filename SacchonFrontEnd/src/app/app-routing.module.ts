import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BglAddNewComponent } from './bgl-add-new/bgl-add-new.component';
import { BglEditComponent } from './bgl-edit/bgl-edit.component';
import { BglComponent } from './bgl/bgl.component';
import { MyAccountComponent } from './my-account/my-account.component';

const routes: Routes = [
  { path: 'my-account', component: MyAccountComponent},
  { path: 'bgl', component: BglComponent},
  { path: 'bgl/new', component: BglAddNewComponent},
  { path: 'bgl/edit', component: BglEditComponent}
  
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
