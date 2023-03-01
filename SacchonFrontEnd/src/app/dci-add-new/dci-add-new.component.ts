import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DciService } from '../services/dci.service';


@Component({
  selector: 'app-dci-add-new',
  templateUrl: './dci-add-new.component.html',
  styleUrls: ['./dci-add-new.component.scss']
})
export class DciAddNewComponent implements OnInit {

  response: any;
  createForm: any;



  // data =
  // {
  //   "name": "morpheus",
  //   "job": "leader"
  // }

  constructor(private service: DciService, private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    //  this.service.create_bgl(this.data).subscribe({
    //   next: data => this.response = data
    //  });

    this.createForm = this.fb.group({
      measurement: ["", [Validators.required]],
      date: ["", [Validators.required]],
    })
  }
  redirect_add(){
    setTimeout(() => {
    this.router.navigate(['/dci']);
  }, 100);
}

  createDCI() {
    const data = {
      id: null,
      measurement: this.createForm.get('measurement').value,
      date: this.createForm.get('date').value,
      patientId: 1
    }

    this.service.create_dci(data).subscribe({
      next: res => this.response = res
    });
  }

}

