import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class FormService {

  constructor(private http: HttpClient) { }

  getTipologieFornitore(): Observable<any> {
    return this.http.get('http://localhost:8080/fornitore/all');
  }

  loadDocs(tipoFornitore: string) {
    return this.http.get('http://localhost:8080/documenti/' + tipoFornitore);
  }
}
