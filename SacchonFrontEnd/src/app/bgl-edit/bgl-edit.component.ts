import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BglComponent } from '../bgl/bgl.component';
import { BglService } from '../services/bgl.service';

@Component({
  selector: 'app-bgl-edit',
  templateUrl: './bgl-edit.component.html',
  styleUrls: ['./bgl-edit.component.scss']
})

export class BglEditComponent implements OnInit, AfterViewInit {

  response: any;
  createForm: any;
  bgl: any;
  bglbyid: BglComponent | undefined;

  // @ViewChild(BglComponent) ;


  // data =
  // {
  //   "name": "morpheus",
  //   "job": "leader"
  // }

  constructor(private service: BglService, private fb: FormBuilder) { }
  ngAfterViewInit(): void {
    throw new Error('Method not implemented.');
  }



  ngOnInit(): void {
    this.bgl = this.service.get().subscribe({
      next: res => this.bgl = res
    });


    this.createForm = this.fb.group({
      measurement: ["", [Validators.required]],
      date: ["", [Validators.required]],
      time: ["", [Validators.required]]
    })
  }
  // this.bglbyid?.bglbyid.id
  updateBGL() {
    const data = {
      id: 14, 
      measurement: this.createForm.get('measurement').value,
      date: this.createForm.get('date').value,
      time: this.createForm.get('time').value,
      patientId: 2
    }

    this.service.update_bgl(data).subscribe({
      next: res => this.response = res
    });
  }

}