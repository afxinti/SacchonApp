import { Component, Input, OnInit } from '@angular/core';
import { DashboardService } from '../services/dashboard.service';

@Component({
  selector: 'app-recordings-progress',
  templateUrl: './recordings-progress.component.html',
  styleUrls: ['./recordings-progress.component.scss']
})
export class RecordingsProgressComponent implements OnInit {

  numRecordings: number = 0;
  bglrec: number | undefined;
  dcirec: number | undefined;

  constructor(private service: DashboardService) { }

  ngOnInit(): void {
    this.service.getNumberofBGLRecords_Progress().subscribe({
      next: res => {
        console.log('BGL records:', res);
        this.bglrec = res as number;
        this.updateNumRecordings();
      }
    });

    this.service.getNumberofDCIRecords_Progress().subscribe({
      next: res => {
        this.dcirec = res as number;
        this.updateNumRecordings();
      }
    });
  }

  updateNumRecordings() {
    if (typeof this.bglrec !== 'undefined' && typeof this.dcirec !== 'undefined') {
      this.numRecordings = this.bglrec + this.dcirec;
    }
  }
}