import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DashboardService } from '../services/dashboard.service';

@Component({
  selector: 'app-statistics-bgl',
  templateUrl: './statistics-bgl.component.html',
  styleUrls: ['./statistics-bgl.component.scss']
})
export class StatisticsBglComponent implements OnInit {
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


  getBGLStatistics() {

    this.val1 = this.createForm.get('startDate').value,
    this.val2 = this.createForm.get('endDate').value,

    this.service.getBGLStatistics(this.val1, this.val2).subscribe({
      next: res => this.response = res
    });
  }

  get startDate(){
    return this.createForm.get('startDate');
  }

  get endDate(){
    return this.createForm.get('endDate');
  }

  
}
