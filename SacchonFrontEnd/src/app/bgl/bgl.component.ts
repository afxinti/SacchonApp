import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
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


  constructor(private service: BglService, private router: Router) { }

  ngOnInit(): void {
    this.bgl = this.service.get().subscribe({
      next: resp => this.bgl = resp
    });
  }

  redirect_edit(){
    setTimeout(() => {
    this.router.navigate(['/bgl/edit']);
  }, 100);
}


  // deleteBGL(bglid: string) {
  //   this.service.delete_bgl(bglid).subscribe({
  //     next: response => {
  //       this.bgl = response;
  //     },
  //     error: err => { console.log(err.message) }
  //   });
  // }

  getBGLById(id: string) {
    this.bglbyid = this.service.getById(id).subscribe({
      next: res => {this.bglbyid = res;
        localStorage.setItem("bglid", this.bglbyid.id);
        localStorage.setItem("bgldate", this.bglbyid.date);
        localStorage.setItem("bgltime", this.bglbyid.time);
        localStorage.setItem("bglmeasurement", this.bglbyid.measurement);
      }
    

    });
  }
  onDelete(bglid: string): void {
    const confirmation = confirm('Are you sure you want to delete this value?');
    if (confirmation) {
      this.service.delete_bgl(bglid).subscribe(
        () => {
          alert('Account deleted successfully.');
          // Add any additional functionality here to update the UI as needed
        },
        error => {
          alert('An error occurred while deleting the account.');
          console.error(error);
        }
      );
    }
  }
}
