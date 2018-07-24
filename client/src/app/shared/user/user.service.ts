import { Injectable } from '@angular/core';

import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/users');
  }

  getPassword(vatNum: string, password: string) {
    return this.http.post('//localhost:8080/login', {'password' : password, 'vatnum': vatNum });
  }

  getPasswordPost(vatNum: string, password: string) {
    const datiAccesso = new FormData();
    datiAccesso.append('vatnum', vatNum);
    datiAccesso.append('password', password);
    return this.http.post('//localhost:8080/login', datiAccesso);
  }
}
