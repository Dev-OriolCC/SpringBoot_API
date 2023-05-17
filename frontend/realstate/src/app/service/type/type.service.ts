import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_ENDPOINT } from 'src/constants';

@Injectable({
  providedIn: 'root'
})
export class TypeService {

  constructor(private http: HttpClient) {}

  getAllTypes(): Observable<any> {
    return this.http.get(API_ENDPOINT+'/types');
  }

  getById(id: string): Observable<any> {
    return this.http.get(API_ENDPOINT+`/types/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post('/api/data', data);
  }

  update(id: string, data: any): Observable<any> {
    return this.http.put(`/api/data/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`/api/data/${id}`);
  }

}
