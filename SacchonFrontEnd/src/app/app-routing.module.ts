import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BglAddNewComponent } from './bgl-add-new/bgl-add-new.component';
import { BglEditComponent } from './bgl-edit/bgl-edit.component';
import { BglComponent } from './bgl/bgl.component';
import { MyAccountComponent } from './my-account/my-account.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoadingComponent } from './loading/loading.component';
import { DciComponent } from './dci/dci.component';
import { DciAddNewComponent } from './dci-add-new/dci-add-new.component';
import { DciEditComponent } from './dci-edit/dci-edit.component';

const routes: Routes = [
  { path: '', component: LoadingComponent},
  { path: 'my-account', component: MyAccountComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'bgl', component: BglComponent},
  { path: 'bgl/new', component: BglAddNewComponent},
  { path: 'bgl/edit', component: BglEditComponent},
  { path: 'dci', component: DciComponent},
  { path: 'dci/new', component: DciAddNewComponent},
  { path: 'dci/edit', component: DciEditComponent}

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
