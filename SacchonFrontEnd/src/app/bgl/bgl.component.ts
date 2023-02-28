import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BglEditComponent } from '../bgl-edit/bgl-edit.component';
import { BglService } from '../services/bgl.service';
import { PatientService } from '../services/patient.service';

@Component({
  selector: 'app-bgl',
  templateUrl: './bgl.component.html',
  styleUrls: ['./bgl.component.scss']
})
export class BglComponent implements OnInit {


  bgl: any;
  bglbyid: any;


  constructor(private service: BglService) { }

  ngOnInit(): void {
    this.bgl = this.service.get().subscribe({
      next: resp => this.bgl = resp
    });
  }


  deleteBGL(bglid: string) {
    this.service.delete_bgl(bglid).subscribe({
      next: response => {
        this.bgl = response;
      },
      error: err => { console.log(err.message) }
    });
  }

  getBGLById(id: string) {
    this.bglbyid = this.service.getById(id).subscribe({
      next: res => this.bglbyid = res,
  
    });
  }
}