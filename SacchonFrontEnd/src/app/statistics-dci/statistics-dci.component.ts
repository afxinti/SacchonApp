import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from '../services/dashboard.service';


@Component({
  selector: 'app-statistics-dci',
  templateUrl: './statistics-dci.component.html',
  styleUrls: ['./statistics-dci.component.scss']
})
export class StatisticsDciComponent implements OnInit{
  response:any;

  val1:any;
  val2:any;

  createForm: any ;
  
  constructor(private service: DashboardService, private fb: FormBuilder) { } 
  
  ngOnInit(): void {
    this.createForm = this.fb.group({
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]]
    }); 
  }


  getDCIStatistics() {

    this.val1 = this.createForm.get('startDate').value,
    this.val2 = this.createForm.get('endDate').value,

    this.service.getDCIStatistics(this.val1, this.val2).subscribe({
      next: res => this.response = res
    })
  }


  get startDate(){
    return this.createForm.get('startDate');
  }

  get endDate(){
    return this.createForm.get('endDate');
  }

  

}
