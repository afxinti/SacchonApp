import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BglComponent } from '../bgl/bgl.component';

@Injectable({
  providedIn: 'root'
})
export class DciService {

  constructor(private http:HttpClient) { }

  get() {
    return this.http.get('http://localhost:9000/dci');
  }

  getById(Id: String){
 
    return this.http.get('http://localhost:9000/dci/' + Id);
  }

  delete_dci(dciid: String){
    return this.http.delete('http://localhost:9000/dci/' + dciid);
  }

create_dci(data: any){
  const url = 'http://localhost:9000/dci';

  const headers =  new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('crossDomain', 'true');

  
  return this.http.post(url, JSON.stringify(data), {headers:headers});
}

update_dci(data: any){

  const url = 'http://localhost:9000/dci/' + localStorage.getItem("dciid");

  const headers =  new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('crossDomain', 'true');

  
  return this.http.put(url, JSON.stringify(data), {headers:headers});
}



}