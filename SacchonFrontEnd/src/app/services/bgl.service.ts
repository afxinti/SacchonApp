import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BglComponent } from '../bgl/bgl.component';

@Injectable({
  providedIn: 'root'
})
export class BglService {

  constructor(private http:HttpClient) { }

  get() {
    return this.http.get('http://localhost:9000/bgl/');
  }

  getById(Id: String){
 
    return this.http.get('http://localhost:9000/bgl/' + Id);
  }

  delete_bgl(bglid: String){
    return this.http.delete('http://localhost:9000/bgl/' + bglid);
  }

create_bgl(data: any){
  const url = 'http://localhost:9000/bgl';

  const headers =  new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('crossDomain', 'true');

  
  return this.http.post(url, JSON.stringify(data), {headers:headers});
}

update_bgl(data: any){

  const url = 'http://localhost:9000/bgl/' + localStorage.getItem("bglid");

  const headers =  new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('crossDomain', 'true');

  
  return this.http.put(url, JSON.stringify(data), {headers:headers});
}

// checkLowRecordings(){
//   return this.http.get('http://localhost:9000/bgl/2/checkLowRecordsExist');
// }



}