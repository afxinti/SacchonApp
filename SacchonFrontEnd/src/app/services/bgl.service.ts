import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BglComponent } from '../bgl/bgl.component';

@Injectable({
  providedIn: 'root'
})
export class BglService {

  constructor(private http:HttpClient) { }

  get() {
    return this.http.get('http://localhost:8080/bgl');
  }

  getById(Id: String){
 
    return this.http.get('http://localhost:8080/bgl/' + Id);
  }

  delete_bgl(bglid: String){
    return this.http.delete('http://localhost:8080/bgl_delete/' + bglid);
  }

create_bgl(data: any){
  const url = 'http://localhost:8080/bgl';

  const headers =  new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('crossDomain', 'true');

  
  return this.http.post(url, JSON.stringify(data), {headers:headers});
}

update_bgl(data: any){

  const url = 'http://localhost:8080/bgl/10';

  const headers =  new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('crossDomain', 'true');

  
  return this.http.put(url, JSON.stringify(data), {headers:headers});
}



}