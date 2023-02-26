import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DashboardService } from '../services/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit{
  
  constructor(private service: DashboardService) { } 

  doctor: any;

  
  ngOnInit(): void {
    this.doctor = this.service.getDoctor().subscribe({ 
      next: res => this.doctor = res }); 
   
  }


  

}
