import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class UploadService {

private uploadUrl = 'http://localhost:8080/fornitoriTemp';

  constructor(private http: HttpClient) { }

  uploadForm(data: FormData) {
    return this.http.post(this.uploadUrl, data, {observe: 'events'});
  }
}
