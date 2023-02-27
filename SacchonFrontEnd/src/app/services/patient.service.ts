import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  
  constructor(private http:HttpClient) { }

  get() {
    return this.http.get('http://localhost:8080/patient/2');
  }

  delete_account(){
    return this.http.delete('http://localhost:8080/patient/2');
  }
  
}