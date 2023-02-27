import { Component, OnInit } from '@angular/core';
import { BglService } from '../services/bgl.service';

@Component({
  selector: 'app-bgl',
  templateUrl: './bgl.component.html',
  styleUrls: ['./bgl.component.scss']
})
export class BglComponent implements OnInit{

  bgl: any;

  constructor(private service: BglService) { } 
  
  ngOnInit(): void { 
    this.bgl = this.service.get().subscribe({ 
      next: res => this.bgl = res }); 
  }

  deleteBGL(bglid: string) {
    this.service.delete_bgl(bglid).subscribe({
      next: response => {
        this.bgl = response;
      },
      error: err => { console.log(err.message )}
    });
  }
}