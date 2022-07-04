import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ImportInvoice} from "./model/import-invoice";
import {Page} from 'ngx-pagination/dist/pagination-controls.directive';

const API_URL1 = `${environment.apiUrl1}`;

@Injectable({
  providedIn: 'root'
})
export class ImportInvoiceService {

  constructor(private http: HttpClient) {}

  public getAll(request): Observable<any> {
    const params = request;
    return this.http.get<Page>(API_URL1+'api/manager-medicine/import-invoice', {params});
    // return this.http.get<Page>('http://localhost:8080/api/manager-medicine/import-invoice', {params});
  }

  public delete(id: string): Observable<ImportInvoice> {
    return this.http.delete<ImportInvoice>(`${API_URL1}api/manager-medicine/import-invoice/${id}`);
  }
}
