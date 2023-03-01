import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http:HttpClient) { }

  //Dashboard Services

  getDoctor(){
    return this.http.get('http://localhost:9000/doctor/1');
  }

  getBGLStatistics(val1: any, val2: any) {
    const url = 'http://localhost:9000/bgl/2/avg/between-dates';

    let queryParams = new HttpParams();
    queryParams = queryParams.append('startDate', val1);
    queryParams = queryParams.append('endDate', val2);
    return this.http.get(url, { params: queryParams });
  }

  getDCIStatistics(val1: any, val2: any) {
    const url = 'http://localhost:9000/dci/2/avg/between-dates';

    let queryParams = new HttpParams();
    queryParams = queryParams.append('startDate', val1);
    queryParams = queryParams.append('endDate', val2);
    return this.http.get(url, { params: queryParams });
  }


  getWarning()  {
    return this.http.get('http://localhost:9000/patient/2/warning');
  }

  getLastConsoltation(){
    return this.http.get('http://localhost:9000/patient/2/lastconsultation');
  }

  getNumberofRecords_Progress(){
    return this.http.get('http://localhost:9000');
  }
}
