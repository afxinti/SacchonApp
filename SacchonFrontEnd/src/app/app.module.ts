import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MyAccountComponent } from './my-account/my-account.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { StatisticsBglComponent } from './statistics-bgl/statistics-bgl.component';
import { StatisticsDciComponent } from './statistics-dci/statistics-dci.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WarningComponent } from './warning/warning.component';
import { LastConsoltationComponent } from './last-consoltation/last-consoltation.component';
import { LoadingComponent } from './loading/loading.component';
import { BglComponent } from './bgl/bgl.component';
import { BglEditComponent } from './bgl-edit/bgl-edit.component';
import { BglAddNewComponent } from './bgl-add-new/bgl-add-new.component';
import { ConsultationsListComponent } from './consultations-list/consultations-list.component';
import { RecordingsProgressComponent } from './recordings-progress/recordings-progress.component';
import { DciComponent } from './dci/dci.component';
import { DciAddNewComponent } from './dci-add-new/dci-add-new.component';
import { DciEditComponent } from './dci-edit/dci-edit.component';


@NgModule({
  declarations: [
    AppComponent,
    MyAccountComponent,
    DashboardComponent,
    StatisticsBglComponent,
    StatisticsDciComponent,
    WarningComponent,
    LastConsoltationComponent,
    MyAccountComponent,
    SidebarComponent,
    LoadingComponent,
    BglComponent,
    BglEditComponent,
    ConsultationsListComponent,
    RecordingsProgressComponent
    BglAddNewComponent,
    DciComponent,
    DciAddNewComponent,
    DciEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
