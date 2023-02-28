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


  onDelete(): void {
    const confirmation = confirm('Are you sure you want to delete this account?');
    if (confirmation) {
      this.service.delete_account().subscribe(
        () => {
          alert('Account deleted successfully.');
          // Add any additional functionality here to update the UI as needed
        },
        error => {
          alert('An error occurred while deleting the account.');
          console.error(error);
        }
      );
    }
  }
}
      
  








