import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.scss']
})
export class LoadingComponent {
  constructor(private router: Router) {
    setTimeout(() => {
      this.router.navigate(['/dashboard']);
    }, 3800);
  }
}
