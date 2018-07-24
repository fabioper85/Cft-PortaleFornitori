import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DocumentService {

    private getDocumentsUrl = 'http://localhost:8080/documenti/';

    constructor(private http: HttpClient) { }

    getDocumentList(tipoFornitore: any) {
        return this.http.get(this.getDocumentsUrl + tipoFornitore);
    }
}
