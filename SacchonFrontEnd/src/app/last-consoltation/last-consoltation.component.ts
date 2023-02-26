import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../services/dashboard.service';

@Component({
  selector: 'app-last-consoltation',
  templateUrl: './last-consoltation.component.html',
  styleUrls: ['./last-consoltation.component.scss']
})
export class LastConsoltationComponent implements OnInit{
  
  last_consultation:any;

  constructor(private service: DashboardService) { } 


  ngOnInit(): void { 
    this.last_consultation = this.service.getLastConsoltation().subscribe({ next: res => this.last_consultation = res }); 
  }


}
