import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientService } from '../services/patient.service';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.scss']
})
export class MyAccountComponent implements OnInit{

  patient: any;

  constructor(private service: PatientService, private router: Router) { }
  
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
          this.router.navigate(['']);
        },
        error => {
          alert('An error occurred while deleting the account.');
          console.error(error);
        }
      );
    }
  }
}
      
  








