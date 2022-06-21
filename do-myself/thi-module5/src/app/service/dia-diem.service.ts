import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DiaDiem} from '../model/dia-diem';

const API_URL = `${environment.apiUrl}`;
const API_URL1 = `${environment.apiUrl1}`;

@Injectable({
  providedIn: 'root'
})
export class DiaDiemService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<DiaDiem[]> {
    return this.http.get<DiaDiem[]>(API_URL1 + '/listDiaDiem');
  }
}
