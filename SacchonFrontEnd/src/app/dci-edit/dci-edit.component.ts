import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BglComponent } from '../bgl/bgl.component';
import { BglService } from '../services/bgl.service';
import { Router } from '@angular/router';
import { DciService } from '../services/dci.service';

@Component({
  selector: 'app-dci-edit',
  templateUrl: './dci-edit.component.html',
  styleUrls: ['./dci-edit.component.scss']
})

export class DciEditComponent implements OnInit, AfterViewInit {

  response: any;
  createForm: any;
  dci: any;

  // @ViewChild(BglComponent) ;


  // data =
  // {
  //   "name": "morpheus",
  //   "job": "leader"
  // }

  constructor(private service: DciService, private fb: FormBuilder, private router: Router) { }
  ngAfterViewInit(): void {
    throw new Error('Method not implemented.');
  }

  redirect(){
    setTimeout(() => {
    this.router.navigate(['/dci']);
  }, 100);
}

  ngOnInit(): void {
    this.dci = this.service.get().subscribe({
      next: res => this.dci = res
    });


    this.createForm = this.fb.group({
      measurement: [localStorage.getItem("dcimeasurement"),  [Validators.required]],
      date: [localStorage.getItem("dcidate"), [Validators.required]],
    })
  }
  // this.bglbyid?.bglbyid.id
  updateBGL() {
    const data = {
      id: localStorage.getItem("dciid"), 
      measurement: this.createForm.get('measurement').value,
      date: this.createForm.get('date').value,
      patientId: 1
    }

    this.service.update_dci(data).subscribe({
      next: res => this.response = res
    });
    
  }
  // constructor(private router: Router) {
  //   setTimeout(() => {
  //     this.router.navigate(['/dashboard']);
  //   }, 6000);
  // }

}