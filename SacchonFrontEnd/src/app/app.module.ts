import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MyAccountComponent } from './my-account/my-account.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { BglComponent } from './bgl/bgl.component';
import { DciComponent } from './dci/dci.component';
import { BglAddNewComponent } from './bgl-add-new/bgl-add-new.component';
import { BglEditComponent } from './bgl-edit/bgl-edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MyAccountComponent,
    SidebarComponent,
    BglComponent,
    DciComponent,
    BglAddNewComponent,
    BglEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }