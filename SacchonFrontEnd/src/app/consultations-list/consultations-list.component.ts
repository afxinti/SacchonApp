import { Component, OnInit } from '@angular/core';
import { PatientService } from '../services/patient.service';

@Component({
  selector: 'app-consultations-list',
  templateUrl: './consultations-list.component.html',
  styleUrls: ['./consultations-list.component.scss']
})
export class ConsultationsListComponent implements OnInit{

  consultation: any;

  constructor(private service: PatientService) { } 
  
  ngOnInit(): void {
    this.consultation = this.service.getPatientsConsultations().subscribe({ 
      next: res => this.consultation = res }); 
  }


}
