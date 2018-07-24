import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UploadService {

private uploadUrl = 'http://localhost:8080/fornitoriTemp';
private getDocsUrl = 'http://localhost:8080/documenti/';

  constructor(private http: HttpClient) { }

  uploadForm(data: FormData) {
    return this.http.post(this.uploadUrl, data, {observe: 'events'});
  }

  getDocsByTipoFornitore(tipoFornitore: string) {
    return this.http.get(this.getDocsUrl + tipoFornitore);
  }
}
