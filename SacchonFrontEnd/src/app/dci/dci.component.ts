import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DciService } from '../services/dci.service';

@Component({
  selector: 'app-dci',
  templateUrl: './dci.component.html',
  styleUrls: ['./dci.component.scss']
})
export class DciComponent implements OnInit {


  dci: any;
  dcibyid: any;


  constructor(private service: DciService, private router: Router) { }

  ngOnInit(): void {
    this.dci = this.service.get().subscribe({
      next: resp => this.dci = resp
    });
  }

  redirect_edit(){
    setTimeout(() => {
    this.router.navigate(['/dci/edit']);
  }, 100);
}


  deleteDCI(dciid: string) {
    this.service.delete_dci(dciid).subscribe({
      next: response => {
        this.dci = response;
      },
      error: err => { console.log(err.message) }
    });
  }

  getDCIById(id: string) {
    this.dcibyid = this.service.getById(id).subscribe({
      next: res => {this.dcibyid = res;
        localStorage.setItem("dciid", this.dcibyid.id);
        localStorage.setItem("dcidate", this.dcibyid.date);
        localStorage.setItem("dcimeasurement", this.dcibyid.measurement);
      }
    

    });
  }
  // onDelete(dciid: string): void {
  //   const confirmation = confirm('Are you sure you want to delete this value?');
  //   if (confirmation) {
  //     this.service.delete_dci(dciid).subscribe(
  //       () => {
  //         alert('Account deleted successfully.');
  //         // Add any additional functionality here to update the UI as needed
  //       },
  //       error => {
  //         alert('An error occurred while deleting the account.');
  //         console.error(error);
  //       }
  //     );
  //   }
  // }
}
