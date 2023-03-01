import { Component, Input, OnInit } from '@angular/core';
import { DashboardService } from '../services/dashboard.service';

@Component({
  selector: 'app-recordings-progress',
  templateUrl: './recordings-progress.component.html',
  styleUrls: ['./recordings-progress.component.scss']
})
export class RecordingsProgressComponent implements OnInit {

  numRecordings: any = 0;


  constructor(private service: DashboardService) { }

  ngOnInit(): void {
    this.numRecordings = this.service.getNumberofRecords_Progress().subscribe({ next: res => this.numRecordings = res });

  }

  
}