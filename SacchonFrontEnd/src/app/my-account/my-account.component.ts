import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient.service';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.scss']
})
export class MyAccountComponent implements OnInit{

  patient: any;

  constructor(private service: PatientService) { } 
  
  ngOnInit(): void { 
    this.patient = this.service.get().subscribe({ 
      next: res => this.patient = res }); 
  }


  deleteAccount() {
    this.service.delete_account().subscribe({
      next: response => {
        this.patient = response;
      },
      error: err => { console.log(err.message )}
    });
  }
}
      
  








