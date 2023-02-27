import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../services/dashboard.service';


@Component({
  selector: 'app-warning',
  templateUrl: './warning.component.html',
  styleUrls: ['./warning.component.scss']
})
export class WarningComponent implements OnInit{

  warning:any;

  constructor(private service: DashboardService) { } 


  ngOnInit(): void { 
    this.service.getWarning().subscribe({ next: res => this.warning =  res});
     
  }


}