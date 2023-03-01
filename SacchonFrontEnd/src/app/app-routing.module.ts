import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultationsListComponent } from './consultations-list/consultations-list.component';
import { BglAddNewComponent } from './bgl-add-new/bgl-add-new.component';
import { BglEditComponent } from './bgl-edit/bgl-edit.component';
import { BglComponent } from './bgl/bgl.component';
import { MyAccountComponent } from './my-account/my-account.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoadingComponent } from './loading/loading.component';

const routes: Routes = [
  { path: '', component: LoadingComponent},
  { path: 'my-account', component: MyAccountComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'bgl', component: BglComponent},
  { path: 'bgl/new', component: BglAddNewComponent},
  { path: 'bgl/edit', component: BglEditComponent},
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
