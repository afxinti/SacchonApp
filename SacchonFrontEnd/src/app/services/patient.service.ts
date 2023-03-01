import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  
  constructor(private http:HttpClient) { }

  get() {
    return this.http.get('http://localhost:9000/patient/1');
  }
  delete_account(){
    return this.http.delete('http://localhost:9000/patient/1');
  }


}
